import javax.swing.*;
import java.awt.event.*;//for ActionListener
import java.util.ArrayList;
import java.awt.*;

public class CalculatorFinal extends JFrame implements ActionListener {
   
    ArrayList <Double> nums= new ArrayList<Double>();
    ArrayList <String> op= new ArrayList<String>();

    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0;
    JButton []numButtons = new JButton[10];
    JButton []opButtons = new JButton[12];
   
    JLabel background;
    
    JButton bsqrt,bpoint,bclear,bdiv,bmul,bdel,bmin,badd,beq,btog,bpow,bmod;
    
    String cvalue;

   Font myFont = new Font("Ethnocentric Rg",Font.PLAIN,25);

    JTextField tfield;
    JPanel panelmain;
    JPanel panelside ;     
    JPanel panelup , upperPanel;
    
    CalculatorFinal(){

        JFrame frame = new JFrame("Calculator");
        ImageIcon icon2= new ImageIcon("bg2.jpg");
        ImageIcon icon = new ImageIcon("calcu.png");
       
        //TEXTFIELD
        tfield= new JTextField();
      
        tfield.setBounds(17,20,350,60); 
        tfield.setLayout(null);
        tfield.setEditable(false);
        tfield.setFont(new Font("Ethnocentric Rg",Font.PLAIN,20));
        tfield.setHorizontalAlignment(JTextField.RIGHT);
        tfield.setForeground(Color.white);
        tfield.setBackground(new Color(96, 64, 32,200));
        tfield.setOpaque(false);
        
       //PANELS
        panelmain = new JPanel();
        panelside = new JPanel();
        panelup = new JPanel();
        upperPanel = new JPanel();
       
        //LABEL
        background = new JLabel(icon2);
        background.setSize(400,500);

        //UPPER PANEL
        
        panelup.setBounds(0,145,390,55);
        panelup.setLayout(new GridLayout(1,4,10,10));
        panelup.setBackground(new Color(0,0,0,0));
        panelup.setOpaque(false);
        
        //SIDEPANEL
     
        panelside.setBounds(300,210,100,250);
        panelside.setLayout(null);
        panelside.setBackground(new Color(0,0,0,100));   
        panelside.setOpaque(false);

        //PINAKAUPPER PANEL
        upperPanel.setBounds(0,85,390,55);
        upperPanel.setLayout(null);
        upperPanel.setBackground(new Color(0,0,0,100));   
        upperPanel.setOpaque(false);
        
        
        
        
        //NUMBER PANEL
     
        panelmain.setBounds(0, 210, 290, 250);
        panelmain.setLayout(new GridLayout(4,3,10,10));
        panelmain.setBackground(new Color(0,0,0,100));       
        panelmain.setOpaque(false);

        
        //PINAKA UPPER BUTTONS
        bpow = new JButton("pow");
        bpow.setBounds(0,0 ,90,55);
        bmod = new JButton("%");
        bmod.setBounds(300,0 ,90,55);


        //UPPER BUTTONS
        bclear = new JButton("C");   
        bdiv = new JButton("/");
        bmul = new JButton("x");
        bdel = new JButton("Delete");

        //SIDE BUTTONS
        bmin = new JButton("-");
        bmin.setBounds(0,0 ,85,55);
        badd = new JButton("+");
        badd.setBounds(0,65 ,85,55); 
        beq = new JButton("=");
        beq.setBounds(0,130 ,85,55);
        btog = new JButton("+/-");
        btog.setBounds(0,195,85,55);
        

        bsqrt= new JButton("sqrt");    
        bpoint= new JButton(".");
        
        
        //insert the button to operation button array
        opButtons[0]= bclear;
        opButtons[1]= bdiv;
        opButtons[2]= bmul;
        opButtons[3]= bdel;
        opButtons[4]= badd;
        opButtons[5]= bmin;
        opButtons[6]= beq;
        opButtons[7]= bsqrt;
        opButtons[8]= bpoint;
        opButtons[9]= btog;
        opButtons[10] = bpow;
        opButtons[11] = bmod;

       
       //add actionlistener to operation buttons 
       for(int i = 0 ; i <12;i++){
           opButtons[i].addActionListener(this);
           opButtons[i].setFont(myFont);
           opButtons[i].setFocusable(false);
           opButtons[i].setBackground(new Color(0xd4a677));
           opButtons[i].setForeground(Color.white);
           opButtons[i].setBackground(new Color(0,0,0,0));
           opButtons[i].setOpaque(false);
          
        }
        //Give value to number buttons and insert it in number buttons array 
        for(int number = 0 ; number <10;number++){
            numButtons[number]=new JButton(String.valueOf(number));
            numButtons[number].addActionListener(this);
            numButtons[number].setFont(myFont);
            numButtons[number].setFocusable(false);
            numButtons[number].setBackground(new Color(0,0,0,0));
            numButtons[number].setOpaque(false);
            numButtons[number].setForeground(Color.white);
            
            

          
        }
        bsqrt.setFont(new Font("Ethnocentric Rg",Font.PLAIN,10));
        bpow.setFont(new Font("Ethnocentric Rg",Font.PLAIN,10));
        bdel.setFont(new Font("Ethnocentric Rg",Font.PLAIN,10));
       
        
        //NUMBER PANEL ADD
        panelmain.add(numButtons[7]);
        panelmain.add(numButtons[8]);
        panelmain.add(numButtons[9]);
        panelmain.add(numButtons[4]);
        panelmain.add(numButtons[5]);
        panelmain.add(numButtons[6]);
        panelmain.add(numButtons[1]);
        panelmain.add(numButtons[2]);
        panelmain.add(numButtons[3]);
        panelmain.add(bsqrt);
        panelmain.add(numButtons[0]);
        panelmain.add(bpoint);
        
        //PINAKA UPPER PANEL ADD
        upperPanel.add(bpow);
        upperPanel.add(bmod);

        //UPPPER PANEL ADD
        panelup.add(bclear);
        panelup.add(bdiv);
        panelup.add(bmul);
        panelup.add(bdel);
        
        //SIDE PANEL ADD
        panelside.add(bmin);
        panelside.add(badd);
        panelside.add(beq);
        panelside.add(btog);
        
        
        //FRAME 
        frame.setSize(400,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setIconImage(icon.getImage());
        frame.setLayout(null);
        frame.add (background);
        background.add(panelmain);
        background.add(panelside);
        background.add(panelup);
        background.add(upperPanel);
        background.add(tfield);
       

        frame.setVisible(true);
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //FOR NUMBER BUTTONS
        for(int i = 0; i<10; i++){
            if(e.getSource()==numButtons[i]){
                tfield.setText(tfield.getText().concat(String.valueOf(i)));
                
            }
        }
        //FOR DECIMAL BUTTON
        if(e.getSource()==bpoint){
            
            if(tfield.getText().charAt(tfield.getText().length()-1) != '.'){//check if the last char in the textfield is '.' if not display '.'
            
            tfield.setText(tfield.getText().concat("."));
                }
            
        }

        
        //FOR CLEAR BUTTON
        if(e.getSource()==bclear){
            tfield.setText("");
        }
        //FOR DELETE BUTTON
        if(e.getSource()==bdel){
            String str = tfield.getText();
            tfield.setText("");
            for(int i = 0; i<str.length()-1 ; i++){
                String strnew = str.substring(0, str.length()-1);
                tfield.setText(strnew);
            }

           
        }
        
    
        //FOR SQUARE ROOT
        if(e.getSource()==bsqrt){
            double sqrt = Double.parseDouble(tfield.getText());
            double result;
            result =  Math.sqrt(sqrt);
            tfield.setText(String.valueOf(result));


        }
        //TOGGLE BUTTON
        if(e.getSource()==btog){
            double temp = -1*Double.parseDouble(tfield.getText());
           tfield.setText(String.valueOf(temp));

        }
        //FOR POWER BUTTON
        if(e.getSource()==bpow){ 
            int lastIndex = tfield.getText().length();//ASSIGN THE LAST LAST INDEX IN THE TEXTFIELD
            char lastElement= tfield.getText().charAt(lastIndex-1);//ASSIGN THE CHARACTER IN THE LAST INDEX 

            if(lastElement != ' '){
                cvalue=tfield.getText().concat(" ^ ");
                tfield.setText(cvalue);
            }else 
                System.out.println("Invalid");
        }
        //FOR MODULO BUTTON
        if(e.getSource()==bmod){ 
            int lastIndex = tfield.getText().length();//ASSIGN THE LAST LAST INDEX IN THE TEXTFIELD
            char lastElement= tfield.getText().charAt(lastIndex-1);//ASSIGN THE CHARACTER IN THE LAST INDEX 

            if(lastElement != ' '){
                cvalue=tfield.getText().concat(" % ");
                tfield.setText(cvalue);
            }else 
                System.out.println("Invalid");
        }


        //ADD BUTTON LISTENER
        if(e.getSource()==badd){ 
            int lastIndex = tfield.getText().length();//ASSIGN THE LAST LAST INDEX IN THE TEXTFIELD
            char lastElement= tfield.getText().charAt(lastIndex-1);//ASSIGN THE CHARACTER IN THE LAST INDEX 

            if(lastElement != ' '){//IF THE LAST INDEX IS WHITE SPACE DONT DISPLAY THE ADD BUTTON 
                cvalue=tfield.getText().concat(" + ");
                tfield.setText(cvalue);
            }else 
                System.out.println("Invalid");
        }

           
        
        
        //SUBTRACTION BUTTON LISTENER
        if(e.getSource()==bmin){

            int lastIndex = tfield.getText().length();
            char lastElement= tfield.getText().charAt(lastIndex-1);
           
            if(lastElement != ' '){
                cvalue=tfield.getText().concat(" - ");
                tfield.setText(cvalue);
            }else
                System.out.println("Invalid");
           
           
            
        }
        //MULTIPLICATION LISTENER
        if(e.getSource()==bmul){
            int lastIndex = tfield.getText().length();
            char lastElement= tfield.getText().charAt(lastIndex-1);
           
            if(lastElement != ' '){
                cvalue=tfield.getText().concat(" x " );
                tfield.setText(cvalue);
            }else
                System.out.println("Invalid");
           //assign the x symbol as operator
            
            
        }
        //DIVISION BUTTON LISTENER
        if(e.getSource()==bdiv){
            int lastIndex = tfield.getText().length();
            char lastElement= tfield.getText().charAt(lastIndex-1);
           
            if(lastElement != ' '){
                cvalue=tfield.getText().concat(" / ");
                tfield.setText(cvalue);
            }else
            System.out.println("Invalid");
            
            
        }
        //EQUAL BUTTON 
        if(e.getSource()==beq){
            String equation[]=tfield.getText().split(" ");//SPLIT THE STRING IN THE TEXTFIELD INTO ARRAY OF STRINGS
            
            
            for( int i=0;i<equation.length;i++){
                
                try{
                    nums.add(Double.parseDouble(equation[i]));//PARSE THE ELEMENTS IN THE ARRAY IF IT IS NUMBER ADD INTO THE NUMBER ARRAYLIST
                }
                catch(Exception l){
                    op.add(equation[i]);//IF IT'S NOT ADD IT IN THE OPERATION ARRAYLIST
               
                }
                
            }

            int index=0;
            while(op.size()!=0){//RUN THE LOOP AS LONG AS THERE IS A OPERATOR IN THE ARRAYLIST
                //POWER OR EXPONENT
                if (op.contains("^")) {
                    
                    index = op.indexOf("^");
                    nums.set(index, Math.pow(nums.get(index) , nums.get(index+1)));
              
                //MULTIPLICATION
                }else if (op.contains("x")) {
                    
                    index = op.indexOf("x");//GIVE THE INDEX OF OPERATOR TO INDEX
                    nums.set(index, nums.get(index) * nums.get(index+1));//UPDATE THE ELEMENTS OF THE NUMBER ARRAY LIST BY MULTIPLYING 2 CONSECUTIVE VALUE STARTING FROM THE INDEX OF THE OPERATOR
                
                //DIVISION
                }else if (op.contains("/")) {
                    index = op.indexOf("/"); 
                    if (nums.get(index+1) != 0) {//IF IT IS NOT DIVIDED BY ZERO 
                        nums.set(index, nums.get(index) / nums.get(index+1));							
                      
                    } else {
                        tfield.setText(String.valueOf(0));
                        JOptionPane.showMessageDialog(null, "Cannot be divided","Error",JOptionPane.ERROR_MESSAGE);
                    }
                //MODULO
                }else if (op.contains("%")) {
                    
                    index = op.indexOf("%");//GIVE THE INDEX OF OPERATOR TO INDEX
                    nums.set(index, nums.get(index) % nums.get(index+1));//UPDATE THE ELEMENTS OF THE NUMBER ARRAY LIST BY MULTIPLYING 2 CONSECUTIVE VALUE STARTING FROM THE INDEX OF THE OPERATOR
                
                    
               //ADDITION
                } else if (op.contains("+")) {
                    index = op.indexOf("+");
                    nums.set(index, nums.get(index) + nums.get(index+1));
                   
                //SUBTRACTION    
                } else if (op.contains("-")) {
                    index = op.indexOf("-");
                    nums.set(index, nums.get(index) - nums.get(index+1));
                  
                }
                
                op.remove(index);//REMOVE THE 2 NUMBERS THAT'S BEEN ALREADY SOLVE
                nums.remove(index+1);
                
               
            }
            double answer = nums.get(0);
            tfield.setText(String.valueOf(answer));//DISPLAY THE FINAL ANSWER IN THE TEXTFIELD
        }//EQ
        nums.clear();//CLEAR THE ARRAYLIST AFTER DISPLAYING THE ANSWER
        op.clear();

                  
    }//METHOD
  
 
    public static void main(String args[]){//MAIN METHOD
        new CalculatorFinal();}
    }
    
    
    

