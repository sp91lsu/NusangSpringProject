/*
 * This file is generated by jOOQ.
 */
package com.mycom.jooq;


import com.mycom.jooq.tables.JBoard;
import com.mycom.jooq.tables.JChatMessageRoom;
import com.mycom.jooq.tables.JChatRoom;
import com.mycom.jooq.tables.JChatRoomGuide;
import com.mycom.jooq.tables.JFriend;
import com.mycom.jooq.tables.JItem;
import com.mycom.jooq.tables.JLocation;
import com.mycom.jooq.tables.JNotice;
import com.mycom.jooq.tables.JPayment;
import com.mycom.jooq.tables.JReply;
import com.mycom.jooq.tables.JShop;
import com.mycom.jooq.tables.JUser1;
import com.mycom.jooq.tables.records.JBoardRecord;
import com.mycom.jooq.tables.records.JChatMessageRoomRecord;
import com.mycom.jooq.tables.records.JChatRoomGuideRecord;
import com.mycom.jooq.tables.records.JChatRoomRecord;
import com.mycom.jooq.tables.records.JFriendRecord;
import com.mycom.jooq.tables.records.JItemRecord;
import com.mycom.jooq.tables.records.JLocationRecord;
import com.mycom.jooq.tables.records.JNoticeRecord;
import com.mycom.jooq.tables.records.JPaymentRecord;
import com.mycom.jooq.tables.records.JReplyRecord;
import com.mycom.jooq.tables.records.JShopRecord;
import com.mycom.jooq.tables.records.JUser1Record;

import javax.annotation.Generated;

import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>SPBOOTER</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<JBoardRecord> PK_BOARD = UniqueKeys0.PK_BOARD;
    public static final UniqueKey<JChatMessageRoomRecord> PK_CHAT_MESSAGE_ROOM = UniqueKeys0.PK_CHAT_MESSAGE_ROOM;
    public static final UniqueKey<JChatRoomRecord> PK_CHAT_ROOM = UniqueKeys0.PK_CHAT_ROOM;
    public static final UniqueKey<JChatRoomGuideRecord> PK_CHAT_ROOM_GUIDE = UniqueKeys0.PK_CHAT_ROOM_GUIDE;
    public static final UniqueKey<JFriendRecord> PK_FRIEND = UniqueKeys0.PK_FRIEND;
    public static final UniqueKey<JItemRecord> PK_ITEM = UniqueKeys0.PK_ITEM;
    public static final UniqueKey<JLocationRecord> PK_LOCATION = UniqueKeys0.PK_LOCATION;
    public static final UniqueKey<JNoticeRecord> PK_NOTICE = UniqueKeys0.PK_NOTICE;
    public static final UniqueKey<JPaymentRecord> PK_PAYMENT = UniqueKeys0.PK_PAYMENT;
    public static final UniqueKey<JReplyRecord> PK_REPLY = UniqueKeys0.PK_REPLY;
    public static final UniqueKey<JShopRecord> PK_SHOP = UniqueKeys0.PK_SHOP;
    public static final UniqueKey<JUser1Record> PK_USER1 = UniqueKeys0.PK_USER1;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class UniqueKeys0 {
        public static final UniqueKey<JBoardRecord> PK_BOARD = Internal.createUniqueKey(JBoard.BOARD, "PK_BOARD", JBoard.BOARD.ID);
        public static final UniqueKey<JChatMessageRoomRecord> PK_CHAT_MESSAGE_ROOM = Internal.createUniqueKey(JChatMessageRoom.CHAT_MESSAGE_ROOM, "PK_CHAT_MESSAGE_ROOM", JChatMessageRoom.CHAT_MESSAGE_ROOM.MESSAGENO);
        public static final UniqueKey<JChatRoomRecord> PK_CHAT_ROOM = Internal.createUniqueKey(JChatRoom.CHAT_ROOM, "PK_CHAT_ROOM", JChatRoom.CHAT_ROOM.ROOMNO);
        public static final UniqueKey<JChatRoomGuideRecord> PK_CHAT_ROOM_GUIDE = Internal.createUniqueKey(JChatRoomGuide.CHAT_ROOM_GUIDE, "PK_CHAT_ROOM_GUIDE", JChatRoomGuide.CHAT_ROOM_GUIDE.NO);
        public static final UniqueKey<JFriendRecord> PK_FRIEND = Internal.createUniqueKey(JFriend.FRIEND, "PK_FRIEND", JFriend.FRIEND.FRIEND_NO);
        public static final UniqueKey<JItemRecord> PK_ITEM = Internal.createUniqueKey(JItem.ITEM, "PK_ITEM", JItem.ITEM.ITEMNO);
        public static final UniqueKey<JLocationRecord> PK_LOCATION = Internal.createUniqueKey(JLocation.LOCATION, "PK_LOCATION", JLocation.LOCATION.LOCATIONNO);
        public static final UniqueKey<JNoticeRecord> PK_NOTICE = Internal.createUniqueKey(JNotice.NOTICE, "PK_NOTICE", JNotice.NOTICE.NO);
        public static final UniqueKey<JPaymentRecord> PK_PAYMENT = Internal.createUniqueKey(JPayment.PAYMENT, "PK_PAYMENT", JPayment.PAYMENT.PAYMENTNO);
        public static final UniqueKey<JReplyRecord> PK_REPLY = Internal.createUniqueKey(JReply.REPLY, "PK_REPLY", JReply.REPLY.ID);
        public static final UniqueKey<JShopRecord> PK_SHOP = Internal.createUniqueKey(JShop.SHOP, "PK_SHOP", JShop.SHOP.NO);
        public static final UniqueKey<JUser1Record> PK_USER1 = Internal.createUniqueKey(JUser1.USER1, "PK_USER1", JUser1.USER1.USERNO);
    }
}
