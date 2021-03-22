public class Calculator {
    private double first;
    private double second;
    private double answer;
    private String inter = "";
    private String oP;
    private boolean remember = false;
    private boolean tried = false;

    public Calculator() {}
    public double getFirst() {
        return first;
    }
    public double getSecond() {
        return second;
    }
    public String getAnswer() {
        return String.valueOf(answer);
    }
    public String getOp() {
        return oP;
    }
    public void setRemember(boolean b) {
        remember = b;
    }
    public boolean getRemember() {
        return remember;
    }
    public String getInter() {
        return inter;
    }
    public void delInter() {
        inter = "";
    }
    public void setFirst(int i) {
        first = i;
    }
    public void setSecond(int i) {
        first = i;
    }
    public void operation(String operation) {
        second = 0;
        oP = operation;
    }
    public void setFirst(String i) {
        inter += i;
        first = Double.parseDouble(inter);
        tried = true;
    }
    public boolean getTried() {
        return tried;
    } 
    public void setTried(boolean b) {
        tried = b;
    } 
    public void setSecond(String i) {
        inter += i;
        second = Double.parseDouble(inter);
    }
    public String setInter(String i) {
        inter += i;
        return inter;
    }
    public void delOp() {
        oP = null;
    }
    public void add() {operation("+");}
    public void subtract() {operation("-");}
    public void multiply() {operation("*");}
    public void divide() {operation("/");}
    public void factorial() {operation("!");}
    public void pow() {operation("pow");}
    public void rootSquare() {operation("sqrt");}
    public void nepLog() {operation("ln");}

    public void compute() {
        if (oP == "+") answer = first+second;
        if (oP == "-") answer = first-second;
        if (oP == "*") answer = first*second;
        if (oP == "/") answer = first/second;
        if (oP == "ln") answer = Math.log(first); 
        if (oP == "pow") answer = Math.pow(first, second);
        if (oP == "sqrt") answer = Math.sqrt(first);
        if (oP == "!") answer = Math.round(Math.sqrt(2*Math.PI*first) *Math.pow((first/Math.E),first) * (1+(1/(12*first))));
    }
    
}
