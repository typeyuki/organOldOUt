package com.organOld.dao.entity.label;

public class LabelManImplNum {
    private Long sum;//总人数
    private Long no;//未处理人数
    private Long impl;//已落实人数
    private Long noImpl;//未落实人数

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }

    public Long getImpl() {
        return impl;
    }

    public void setImpl(Long impl) {
        this.impl = impl;
    }

    public Long getNoImpl() {
        return noImpl;
    }

    public void setNoImpl(Long noImpl) {
        this.noImpl = noImpl;
    }
}
