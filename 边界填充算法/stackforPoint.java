/**
 * Created by 我是姚七号 on 2017/9/26.
 */
public class stackforPoint {
    private int size;//栈的大小
    private int top = 0;
    private point nodes[];

    public stackforPoint(int size) {
        this.size = size;
        nodes = new point[size];//只是声明，没有分配内存
    }

    //清空栈
    public void clearStack(){
        this.top = 0;
    }

    //判断栈空,是返回true，否则返回false
    public boolean isEmpty(){
        if(this.top==0){
            return true;
        }else{
            return false;
        }
    }

    //判断栈满，是返回true，否则返回false
    public boolean isFull(){
        if(this.top==this.size){
            return true;
        }else{
            return false;
        }
    }

    //获取栈顶元素,成功返回true，否则返回false，下同
    public boolean getTop(point p){
        if(isEmpty()==false){
            p = nodes[top-1];
            return true;
        }else{
            return false;
        }
    }

    //入栈
    public boolean push(point p){
        if(isFull()==false){
            nodes[top++] = p;
            return true;
        }else{
            return false;
        }
    }

    //出栈，成功返回点，失败返回空指针
    public point pop(){
        if(isEmpty()==false){
            return nodes[--top];
        }else{
            return null;
        }
    }
}
