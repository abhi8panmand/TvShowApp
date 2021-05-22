package com.gravity.tvshows.API;

import lombok.Data;

@Data
public class ResponseData<T> {
    private String name;
    private String type;
    private String message;
    private T logisticapidata;
    private T servermessage;
    private T data;
    private T image;
    private Boolean success;
    private MMessageObject messageobject;

    public T getLogisticapidata() {
        return logisticapidata;
    }

    public void setLogisticapidata(T logisticapidata) {
        this.logisticapidata = logisticapidata;
    }

    public T getServermessage() {
        return servermessage;
    }

    public void setServermessage(T servermessage) {
        this.servermessage = servermessage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getImage() {
        return image;
    }

    public void setImage(T image) {
        this.image = image;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public MMessageObject getMessageobject() {
        return messageobject;
    }

    public void setMessageobject(MMessageObject messageobject) {
        this.messageobject = messageobject;
    }

    public class MMessageObject {

        private String topbanner;
        private String topmessageemptyform;
        private String bottommessageemptyform;
        private String messagefilledform;

        public String getTopbanner() {
            return topbanner;
        }

        public void setTopbanner(String topbanner) {
            this.topbanner = topbanner;
        }

        public String getTopmessageemptyform() {
            return topmessageemptyform;
        }

        public void setTopmessageemptyform(String topmessageemptyform) {
            this.topmessageemptyform = topmessageemptyform;
        }

        public String getBottommessageemptyform() {
            return bottommessageemptyform;
        }

        public void setBottommessageemptyform(String bottommessageemptyform) {
            this.bottommessageemptyform = bottommessageemptyform;
        }

        public String getMessagefilledform() {
            return messagefilledform;
        }

        public void setMessagefilledform(String messagefilledform) {
            this.messagefilledform = messagefilledform;
        }
    }
}
