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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JSpbooter extends SchemaImpl {

    private static final long serialVersionUID = 2145240747;

    /**
     * The reference instance of <code>SPBOOTER</code>
     */
    public static final JSpbooter SPBOOTER = new JSpbooter();

    /**
     * The table <code>SPBOOTER.BOARD</code>.
     */
    public final JBoard BOARD = com.mycom.jooq.tables.JBoard.BOARD;

    /**
     * The table <code>SPBOOTER.CHAT_MESSAGE_ROOM</code>.
     */
    public final JChatMessageRoom CHAT_MESSAGE_ROOM = com.mycom.jooq.tables.JChatMessageRoom.CHAT_MESSAGE_ROOM;

    /**
     * The table <code>SPBOOTER.CHAT_ROOM</code>.
     */
    public final JChatRoom CHAT_ROOM = com.mycom.jooq.tables.JChatRoom.CHAT_ROOM;

    /**
     * The table <code>SPBOOTER.CHAT_ROOM_GUIDE</code>.
     */
    public final JChatRoomGuide CHAT_ROOM_GUIDE = com.mycom.jooq.tables.JChatRoomGuide.CHAT_ROOM_GUIDE;

    /**
     * The table <code>SPBOOTER.FRIEND</code>.
     */
    public final JFriend FRIEND = com.mycom.jooq.tables.JFriend.FRIEND;

    /**
     * The table <code>SPBOOTER.ITEM</code>.
     */
    public final JItem ITEM = com.mycom.jooq.tables.JItem.ITEM;

    /**
     * The table <code>SPBOOTER.LOCATION</code>.
     */
    public final JLocation LOCATION = com.mycom.jooq.tables.JLocation.LOCATION;

    /**
     * The table <code>SPBOOTER.NOTICE</code>.
     */
    public final JNotice NOTICE = com.mycom.jooq.tables.JNotice.NOTICE;

    /**
     * The table <code>SPBOOTER.PAYMENT</code>.
     */
    public final JPayment PAYMENT = com.mycom.jooq.tables.JPayment.PAYMENT;

    /**
     * The table <code>SPBOOTER.REPLY</code>.
     */
    public final JReply REPLY = com.mycom.jooq.tables.JReply.REPLY;

    /**
     * The table <code>SPBOOTER.SHOP</code>.
     */
    public final JShop SHOP = com.mycom.jooq.tables.JShop.SHOP;

    /**
     * The table <code>SPBOOTER.USER1</code>.
     */
    public final JUser1 USER1 = com.mycom.jooq.tables.JUser1.USER1;

    /**
     * No further instances allowed
     */
    private JSpbooter() {
        super("SPBOOTER", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            JBoard.BOARD,
            JChatMessageRoom.CHAT_MESSAGE_ROOM,
            JChatRoom.CHAT_ROOM,
            JChatRoomGuide.CHAT_ROOM_GUIDE,
            JFriend.FRIEND,
            JItem.ITEM,
            JLocation.LOCATION,
            JNotice.NOTICE,
            JPayment.PAYMENT,
            JReply.REPLY,
            JShop.SHOP,
            JUser1.USER1);
    }
}
