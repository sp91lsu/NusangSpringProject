package com.mycom.blog.service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent.Kind;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;

import com.mycom.blog.controller.assist.ConAssist;
import com.mycom.blog.dto.Board;
import com.mycom.blog.dto.User;
import com.mycom.blog.dto.enumtype.GenderType;
import com.mycom.blog.repository.BoardRepository;
import com.mycom.blog.repository.UserRepository;
import com.mycom.blog.vo.BoardVO;
import com.mycom.blog.vo.UserVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class ProfileService {

	@Autowired
	MultipartResolver multiResolver;

	@Autowired
	ConAssist conAssist;

	@Autowired
	UserRepository userRepository;

	@Autowired
	BoardRepository boardRepository;

	// 사진 업데이트
	@Transactional
	public int updatePicture(MultipartFile file, HttpServletRequest request) {

		String savePath = request.getSession().getServletContext().getRealPath("");
		savePath = savePath.replace("webapp", "resources/static/upload");
		System.out.println("업로드 경로:  " + savePath);
		// savePath = "C:\\";
		Date current = new Date();
		String fileName = current.getTime() + "_" + file.getOriginalFilename();

		try {
			User user = userRepository.findById(conAssist.getUserno()).get();

			// 이전 사진파일 지우기
			
			File preFP = new File(savePath +"/" + user.getPicture().split("/")[2]);
			if (preFP.exists() && !user.getPicture().equals("/upload/profileImg.jpg")) {
				preFP.delete();
			}

			File newFile = new File(savePath + fileName);
			file.transferTo(newFile);

			user.setPicture("/upload/" + fileName);

			return 1;
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return -1;

	}

	// 사진 지우기(기본사진으로)
	@Transactional
	public int deletePicture(HttpServletRequest request) {
		String savePath = request.getSession().getServletContext().getRealPath("");
		savePath = savePath.replace("webapp", "resources/static/upload");

		try {
			User user = userRepository.findById(conAssist.getUserno()).get();

			File preFP = new File(savePath +"/" + user.getPicture().split("/")[2]);
			if (preFP.exists() && !user.getPicture().equals("/upload/profileImg.jpg")) {
				preFP.delete();
			}

			user.setPicture("/upload/profileImg.jpg");
			return 1;

		} catch (Exception e) {
		}
		return 0;
	}

	// 닉네임 체인지
	@Transactional
	public int nickNameUpdate(String nickName) {
		String namePattern = "^[a-zA-Z0-9가-힣!@#$%^&*()_+-=~.]{2,8}$"; // 한글만 2~8자
		boolean patChk = Pattern.matches(namePattern, nickName);
		boolean duplChk = true;
		
		List<User> userAll = userRepository.findAll();
		for (User ua : userAll) {
			if(ua.getNickname().equals(nickName)) {
				duplChk = false;
			}
		}

		if (patChk == true && duplChk == true) {
			try {
				User user = userRepository.findById(conAssist.getUserno()).get();
				user.setNickname(nickName);
				return 0;
			} catch (Exception e) {
			}
		} else if(duplChk == false) {
			return 2;
		}
		return 1;
	}

	@Transactional
	public User userChk(User user) {

		if (user.getUserno() == conAssist.getUserno()) {
			user = conAssist.updateUser();
		} else {
			user = userRepository.findById(user.getUserno()).get();
			System.out.println("친구리스트 lazy init");
			Hibernate.initialize(conAssist.updateUser().getFriendList());
		}
		Hibernate.initialize(user.getBoardList());
		return user;
	}

	// 성별 변경
	@Transactional
	public int updateGender(GenderType gender) {
		try {
			User user = userRepository.findById(conAssist.getUserno()).get();
			user.setGender(gender);
			return 1;
		} catch (Exception e) {
		}
		return 0;
	}

	@Transactional
	public int updateAge(int age) {
		try {
			User user = userRepository.findById(conAssist.getUserno()).get();
			user.setAge(age);
			return 1;
		} catch (Exception e) {
		}
		return 0;
	}

	public Page<BoardVO> getPageList(Pageable pageable, User user) {

		System.out.println("무슨글 담고있니?  " + boardRepository.findAll(pageable).getContent());

		Page<Board> boards = boardRepository.findByUser(user, pageable);

		List<BoardVO> boardList = new ArrayList<BoardVO>();
		for (Board board : boards) {
			BoardVO vo = new BoardVO();
			UserVO userVo = new UserVO();
			BeanUtils.copyProperties(board, vo);
			BeanUtils.copyProperties(board.getUser(), userVo);
			vo.setUser(userVo);
			boardList.add(vo);
		}

		Page<BoardVO> boardVoPage = new PageImpl<BoardVO>(boardList, pageable, boardList.size());

		return boardVoPage;
	}

}
