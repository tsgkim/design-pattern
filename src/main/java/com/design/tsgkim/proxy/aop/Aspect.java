package com.design.tsgkim.proxy.aop;

public class Aspect {

    private Advise advise;

    private PointCut pointCut;

    public Advise getAdvise() {
        return advise;
    }

    public void setAdvise(Advise advise) {
        this.advise = advise;
    }

    public PointCut getPointCut() {
        return pointCut;
    }

    public void setPointCut(PointCut pointCut) {
        this.pointCut = pointCut;
    }

}
