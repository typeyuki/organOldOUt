package com.organOld.oService.model;

import com.organOld.dao.util.Page;

public class MessageModel extends Pattern{
    private String cardId;
    private String content;

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
}
