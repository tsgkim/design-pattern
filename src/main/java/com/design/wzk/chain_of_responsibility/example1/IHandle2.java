package com.design.chain_of_responsibility.example1;

public abstract class IHandle2 {
    public final static int FATHER_LEVEL_REQUEST = 1;
    public final static int HUSBAND_LEVEL_REQUEST = 2;
    public final static int SON_LEVEL_REQUEST = 3;

    //能处理的级别
    private int level = 0;
    //责任传递，下一个责任人是谁
    private IHandle2 nextHandle;

    public IHandle2(int level){
          this.level = level;
    }

    public final void handleMessage(IWoman woman){
        if (woman.getType() == this.level){
            this.response(woman);
        }else {
            if (this.nextHandle != null){
                this.nextHandle.handleMessage(woman);
            }else {
                System.out.println("==没地方请示了，按不同意处理==");
            }
        }
    }

    public void setNext(IHandle2 _nextHandle){
        this.nextHandle = _nextHandle;
    }

    //有请示当然要回应
    protected abstract void response(IWoman woman);


}

class Father extends IHandle2{

    public Father() {
        super(IHandle2.FATHER_LEVEL_REQUEST);
    }

    protected void response(IWoman woman) {
        System.out.println("父亲的回答是：同意");
    }
}

class Husband extends IHandle2{


    public Husband() {
        super(IHandle2.HUSBAND_LEVEL_REQUEST);
    }

    protected void response(IWoman woman) {
        System.out.println("丈夫的回答是：同意");
    }
}

class Son extends IHandle2{

    public Son() {
        super(IHandle2.SON_LEVEL_REQUEST);
    }

    protected void response(IWoman woman) {
        System.out.println("儿子的回答是：同意");
    }
}


