package com.organOld.dao.entity;

import com.organOld.dao.entity.organ.Organ;

public class MessageOut extends DBEntity {
    private String cardId;
    private String content;
    private int isRead;


    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public int getIsRead() {
        return isRead;
    }

    public void setIsRead(int isRead) {
        this.isRead = isRead;
    }
}
