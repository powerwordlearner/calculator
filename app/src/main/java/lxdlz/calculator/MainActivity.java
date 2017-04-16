package lxdlz.calculator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import java.math.BigDecimal;
public class MainActivity extends Activity implements OnClickListener{
    //声明一些控件
    Button btn0=null;
    Button btn1=null;
    Button btn2=null;
    Button btn3=null;
    Button btn4=null;
    Button btn5=null;
    Button btn6=null;
    Button btn7=null;
    Button btn8=null;
    Button btn9=null;
    Button btnBackspace=null;
    Button btnCE=null;
    Button btnC=null;
    Button btnAdd=null;
    Button btnSub=null;
    Button btnMul=null;
    Button btnDiv=null;
    Button btnEqu=null;
    Button btnPoint=null;
    Button btnPow=null;
    Button btnExt=null;
    Button btnLeft=null;
    Button btnOpp=null;
    Button btnRec=null;
    TextView tvResult=null;
    TextView tvPreview=null;
    //声明两个参数。接收tvResult前后的值
    String num1="0";
    String num2="0";
    boolean end=true;
    int op=0;//判断操作数，
    boolean anti=false;
    boolean point=false;
    boolean first=true;
    boolean tvanti=false;
    int mode=1;//1 for normal, 2 for instant calculation, 3 for combo calculation
    boolean tvend=true;
    // @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //从布局文件中获取控件，
        btn0=(Button)findViewById(R.id.btn0);
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        btn3=(Button)findViewById(R.id.btn3);
        btn4=(Button)findViewById(R.id.btn4);
        btn5=(Button)findViewById(R.id.btn5);
        btn6=(Button)findViewById(R.id.btn6);
        btn7=(Button)findViewById(R.id.btn7);
        btn8=(Button)findViewById(R.id.btn8);
        btn9=(Button)findViewById(R.id.btn9);
        btnBackspace=(Button)findViewById(R.id.btnBackspace);
        btnCE=(Button)findViewById(R.id.btnCE);
        btnC=(Button)findViewById(R.id.btnC);
        btnEqu=(Button)findViewById(R.id.btnEqu);
        btnAdd=(Button)findViewById(R.id.btnAdd);
        btnSub=(Button)findViewById(R.id.btnSub);
        btnMul=(Button)findViewById(R.id.btnMul);
        btnDiv=(Button)findViewById(R.id.btnDiv);
        btnPoint=(Button)findViewById(R.id.btnPoint);
        btnPow=(Button)findViewById(R.id.btnPow);
        btnExt=(Button)findViewById(R.id.btnExt);
        btnLeft=(Button)findViewById(R.id.btnLeft);
        btnOpp=(Button)findViewById(R.id.btnOpp);
        btnRec=(Button)findViewById(R.id.btnRec);
        tvResult=(TextView)findViewById(R.id.tvResult);
        tvPreview=(TextView)findViewById(R.id.tvPreview);
        //添加监听\
        btnBackspace.setOnClickListener(this);
        btnCE.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnEqu.setOnClickListener(this);
        btnPoint.setOnClickListener(this);
        btnPow.setOnClickListener(this);
        btnExt.setOnClickListener(this);
        btnLeft.setOnClickListener(this);
        btnOpp.setOnClickListener(this);
        btnRec.setOnClickListener(this);
    }
    //初始化
    public void initialize(){
        tvResult.setText("0");
        tvPreview.setText("");
        num1="0";
        num2="0";
        op=0;
        end=true;
        anti=false;
        point=false;
        first=true;
        tvanti=false;
        mode=1;
        tvend=false;
    }
    //调试必备
    public void debug(){
        System.out.println("num1="+num1);
        System.out.println("num2="+num2);
        System.out.println("anti="+anti);
        System.out.println("mode="+mode);
        System.out.println("tvanti="+tvanti);
        System.out.println("tvend="+tvend);
        System.out.println("first="+first);
        System.out.println("end="+end);
        System.out.println("op="+op);
    }
    //检测是否为整数，从而判断怎么显示（有无小数点）
    public String checked(String s){
        if(Double.valueOf(s)%1==0) {
            point = false;
            return(Double.valueOf(s).longValue() + "");
        }
        else {
            point = true;
            return(s + "");
        }
    }
    //计算
    public void exe() {
        try {
            switch (op) {
                case 0:
                    num2=checked(tvResult.getText().toString());
                    num1=num2;
                    end=true;
                    break;
                case 1:
                {num2=checked(tvResult.getText().toString());
                    BigDecimal b1=new BigDecimal(num1);
                    BigDecimal b2=new BigDecimal(num2);
                    num1 = checked(b1.add(b2)+"");}
                break;
                case 2:
                {num2=checked(tvResult.getText().toString());BigDecimal b1=new BigDecimal(num1);
                    BigDecimal b2=new BigDecimal(num2);
                    num1 = checked(b1.subtract(b2)+"");}
                break;
                case 3:
                {num2=checked(tvResult.getText().toString());
                    BigDecimal b1=new BigDecimal(num1);
                    BigDecimal b2=new BigDecimal(num2);
                    num1 = checked(b1.multiply(b2)+"");}
                break;
                case 4:
                    try{num2=checked(tvResult.getText().toString());
                        BigDecimal b1=new BigDecimal(num1);
                        BigDecimal b2=new BigDecimal(num2);
                        num1 = checked(b1.divide(b2)+"");}
                    catch (Exception e){
                        num1=checked(Double.valueOf(num1)/Double.valueOf(tvResult.getText().toString())+"");
                    }
                    break;
                case 7:
                    try{num2=checked(tvResult.getText().toString());
                        BigDecimal b1=new BigDecimal(num1);
                        BigDecimal b2=new BigDecimal(num2);
                        num1 = checked(b1.divideAndRemainder(b2)[1]+"");}
                    catch (Exception e){
                        num1=checked(Double.valueOf(num1)%Double.valueOf(tvResult.getText().toString())+"");
                    }
                    break;
                default:
                    break;
            }
            tvResult.setText(num1);
        }
        catch (Exception e){
            initialize();
        }
    }
    //乘方开方的计算
    public void exe(int i) {
        try {
            switch (i) {
                case 0:
                    num2=checked(tvResult.getText().toString());
                    num1=num2;
                    end=true;
                    break;
                case 5:
                    mode=2;
                    num2=checked(tvResult.getText().toString());
                    num1=checked(Math.pow(Double.valueOf(num2),2)+"");
                    tvResult.setText(num1);
                    end=true;
                    break;
                case 6:
                    mode=2;
                    num2=checked(tvResult.getText().toString());
                    num1=checked(Math.pow(Double.valueOf(num2),1.0/2)+"");
                    tvResult.setText(num1);
                    end=true;
                    break;
                case 8:
                    mode=2;
                    num2=checked(tvResult.getText().toString());
                    num1=checked(1/(Double.valueOf(num2))+"");
                    tvResult.setText(num1);
                    end=true;
                    break;
                default:
                    break;
            }
        }
        catch (Exception e){
            initialize();
        }
    }
    //按下运算按钮的反应（计算之前的准备工作）
    public void EXE(int i){
        if(!anti)exe();
        anti=true;
        tvResult.setText(num1);
        if(i!=0&&i!=5&&i!=6)op=i;
        end=true;
        point=false;
    }
    //检测有无小数点
    public void checkPoint(){
        String myStr=tvResult.getText().toString();
        point=false;
        for(int i=0;i<=myStr.length()-1;i++)
        {
            if(myStr.charAt(i)=='.') {
                point=true;
                break;
            }
        }//check point
        tvResult.setText(myStr.substring(0, myStr.length()));
        if(tvResult.getText().toString().equals("")) {
            end = true;
            tvResult.setText("0");
        }
    }
    //输入数字并显示
    public void enterNumber(int i){
        if(i!=0) {
            if(end) {
                tvResult.setText(null);
                if(op==0){
                    first=true;
                    if(tvend)tvPreview.setText(null);
                }
                end=false;
            }
            String myString=tvResult.getText().toString();
            if(tvResult.getText().toString().equals("0")) myString=i+"";
            else if(tvResult.getText().toString().equals("-0"))myString="-"+i;
            else myString+=i;
            tvResult.setText(myString);
        }
        else {
            if(!end&&!point) {
                String myString=tvResult.getText().toString();
                if(!myString.equals("0"))
                    myString+="0";
                myString= Double.valueOf(myString).longValue()+"";
                tvResult.setText(myString);
            }
            else if(point) {
                String myString=tvResult.getText().toString();
                myString+="0";
                tvResult.setText(myString);
            }
            else tvResult.setText("0");
        }
        if(tvend)tvPreview.setText(null);
        tvend=false;
        anti=false;
        tvanti=false;
        mode=1;
        debug();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //btnBackspace和CE--------------------
            case R.id.btnBackspace:
                if(!end) {
                    try {
                        String myStr;
                        if (!point) myStr = Double.valueOf(tvResult.getText().toString()).longValue() + "";
                        else myStr = tvResult.getText().toString();
                        tvResult.setText(myStr.substring(0, myStr.length()-1));
                        if(tvResult.getText().toString().equals("-"))tvResult.setText("-0");
                        else if (tvResult.getText().toString().equals(""))tvResult.setText("0");
                    }
                    catch (Exception e){
                        tvResult.setText("0");
                    }
                }
                else initialize();
                debug();
                break;
            case R.id.btnCE:
                tvResult.setText("0");
                break;
            case R.id.btnC:
                initialize();
                break;
            //btn0--9---------------------------
            case R.id.btn0:
                enterNumber(0);debug();
                break;
            case R.id.btn1:
                enterNumber(1);debug();
                break;
            case R.id.btn2:
                enterNumber(2);debug();
                break;
            case R.id.btn3:
                enterNumber(3);debug();
                break;
            case R.id.btn4:
                enterNumber(4);debug();
                break;
            case R.id.btn5:
                enterNumber(5);debug();
                break;
            case R.id.btn6:
                enterNumber(6);debug();
                break;
            case R.id.btn7:
                enterNumber(7);debug();
                break;
            case R.id.btn8:
                enterNumber(8);debug();
                break;
            case R.id.btn9:
                enterNumber(9);debug();
                break;
            //btn+-*/=--------------------------------
            case R.id.btnEqu:
                tvPreview.setText("");
                tvanti=false;
                if(mode==3){try{switch(op) {
                    case 0: {
                        BigDecimal b1 = new BigDecimal(num1);
                        num1 = checked(b1 + "");
                    }
                    break;
                    case 1: {
                        BigDecimal b1 = new BigDecimal(num1);
                        BigDecimal b2 = new BigDecimal(num2);
                        num1 = checked(b1.add(b2) + "");
                    }
                    break;
                    case 2: {
                        BigDecimal b1 = new BigDecimal(num1);
                        BigDecimal b2 = new BigDecimal(num2);
                        num1 = checked(b1.subtract(b2) + "");
                    }
                    break;
                    case 3: {
                        BigDecimal b1 = new BigDecimal(num1);
                        BigDecimal b2 = new BigDecimal(num2);
                        num1 = checked(b1.multiply(b2) + "");
                    }
                    break;
                    case 4: try{
                        BigDecimal b1=new BigDecimal(num1);
                        BigDecimal b2=new BigDecimal(num2);
                        num1 = checked(b1.divide(b2)+"");}
                    catch (Exception e){
                        num1=checked(Double.valueOf(num1)/Double.valueOf(num2)+"");
                    }
                    break;
                    case 7:
                        try{
                            BigDecimal b1=new BigDecimal(num1);
                            BigDecimal b2=new BigDecimal(num2);
                            num1 = checked(b1.divideAndRemainder(b2)[1]+"");}
                        catch (Exception e){
                            num1=checked(Double.valueOf(num1)%Double.valueOf(num2)+"");
                        }
                    break;
                }
                    tvResult.setText(num1);}
                catch (Exception e)
                {initialize();}
                }
                else EXE(0);
                mode=3;
                debug();
                break;
            case R.id.btnAdd://按钮+
            {String myStr;
                if(mode==2)myStr="";
                else myStr=tvResult.getText().toString();
                if(!tvanti)tvPreview.setText(tvPreview.getText().toString()+myStr+"+");
                tvanti=true;
                tvend=false;
                first=true;
                tvPreview.setText(tvPreview.getText().toString().substring(0,tvPreview.getText().toString().length()-1)+"+");
                EXE(1);
                debug();}
                break;
            case R.id.btnSub://按钮-
            {String myStr;
                if(mode==2)myStr="";
                else myStr=tvResult.getText().toString();
                if(!tvanti)tvPreview.setText(tvPreview.getText().toString()+myStr+"-");
                tvanti=true;
                tvend=false;
                first=true;
                tvPreview.setText(tvPreview.getText().toString().substring(0,tvPreview.getText().toString().length()-1)+"-");
                EXE(2);
                debug();}
                break;
            case R.id.btnMul://按钮*
            {String myStr;
                if(mode==2)myStr="";
                else myStr=tvResult.getText().toString();
                if(!tvanti)tvPreview.setText(tvPreview.getText().toString()+myStr+"*");
                tvanti=true;
                tvend=false;
                first=true;
                tvPreview.setText(tvPreview.getText().toString().substring(0,tvPreview.getText().toString().length()-1)+"*");
                EXE(3);
                debug();}
                break;
            case R.id.btnDiv://按钮/
            {String myStr;
                if(mode==2)myStr="";
                else myStr=tvResult.getText().toString();
                if(!tvanti)tvPreview.setText(tvPreview.getText().toString()+myStr+"/");
                tvanti=true;
                tvend=false;
                first=true;
                tvPreview.setText(tvPreview.getText().toString().substring(0,tvPreview.getText().toString().length()-1)+"/");
                EXE(4);
                debug();}
                break;
            case R.id.btnPow://按钮乘方
                mode=1;
                op=0;
                if(!first) tvPreview.setText("sqr("+tvPreview.getText().toString()+")");
                else {
                    tvPreview.setText("sqr("+tvResult.getText().toString()+")");
                    first=false;
                }
                exe(5);
                end=true;
                tvend=true;
                tvanti=false;
                debug();
                break;
            case R.id.btnExt://按钮开方
                mode=1;
                op=0;
                if(!first) tvPreview.setText("sqrt("+tvPreview.getText().toString()+")");
                else {
                    tvPreview.setText("sqrt("+tvResult.getText().toString()+")");
                    first=false;
                }
                exe(6);
                end=true;
                tvend=true;
                tvanti=false;
                debug();
                break;
            case R.id.btnLeft://按钮求余
            {String myStr;
                if(mode==2)myStr="";
                else myStr=tvResult.getText().toString();
                if(!tvanti)tvPreview.setText(tvPreview.getText().toString()+myStr+"%");
                tvanti=true;
                tvend=false;
                first=true;
                tvPreview.setText(tvPreview.getText().toString().substring(0,tvPreview.getText().toString().length()-1)+"%");
                EXE(7);
                debug();}
                break;
            case R.id.btnPoint://按钮小数点
                if(!point&&!end) {
                    if (tvResult.getText().toString().equals("-")) {
                        String myStr = tvResult.getText().toString();
                        myStr += "0.";
                        tvResult.setText(myStr);
                        point = true;
                        end = false;
                    }
                    else{
                        String myStr = tvResult.getText().toString();
                        myStr += ".";
                        tvResult.setText(myStr);
                        point = true;
                        end = false;
                    }
                    if(tvend)tvPreview.setText(null);
                    tvend=false;
                    anti=false;
                    tvanti=false;
                }
                else if(end==true) {
                    String myStr = tvResult.getText().toString();
                    myStr = "0.";
                    tvResult.setText(myStr);
                    point = true;
                    end = false;
                }
                debug();
                break;
            case R.id.btnOpp://按钮相反数
                mode=1;
                if(!end){
                    String myStr;
                    if(tvResult.getText().toString().charAt(0)!='-'){
                        if(tvResult.getText().toString().equals("0"))
                            myStr=("-0");
                        else myStr="-"+tvResult.getText().toString();
                        tvResult.setText(myStr);
                    }
                    else{
                        if(tvResult.getText().toString().length()>=2)
                            myStr=tvResult.getText().toString().substring(1,tvResult.getText().toString().length());
                        else myStr="0";
                    }
                    tvResult.setText(myStr);
                }
                else{
                    tvResult.setText("-0");
                    end=false;
                }
                anti=false;
                break;
            case R.id.btnRec://按钮倒数
                op=0;
                if(!first)tvPreview.setText("1/("+tvPreview.getText().toString()+")");
                else tvPreview.setText("1/("+tvResult.getText().toString()+")");
                exe(8);
                first=false;
                end=true;
                tvend=true;
                tvanti=false;
                debug();
                break;
            default:
                break;
        }
        checkPoint();
    }
}
