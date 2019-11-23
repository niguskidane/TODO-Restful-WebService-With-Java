package com.todo.restfulwebservice.model;

public class HelloWorldBean {

    private String message;

    public HelloWorldBean(){

    }

    public HelloWorldBean(String message){
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("HelloWorldBean{");
        sb.append("message='").append(message).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
