package Split;
import java.util.*;
public class BillAdd {
    static split sp;
    static BillAdd bill;
    String billfor;
    int amt;
    String by;
    String date;
    int id;
    BillAdd(String billfor, int amt, String by, String date, int id) {
        this.billfor = billfor;
        this.amt = amt;
        this.by = by;
        this.date = date;
        this.id = id;
    }
    BillAdd(){}
    static int id1 = 100;
    public void billadd(int n,int po,int arrp[][],String [] str,String[]str1){
        System.out.println("Enter the reason :");
        String billfor=split.sc.next();
        System.out.println("Enter the amount :");
        int amt=split.sc.nextInt();
        System.out.println("Enter the number of payers");
        int n3=split.sc.nextInt();
        int amt2=amt/n3;
        System.out.println("Please choose the users :");
        for(split i:split.userlist){
            if(!(i.userid.equals(Integer.toString(po+1)))){
                System.out.println(i.userid + ". "+i.name);
            }
        }
        ArrayList<Integer> arrl=new ArrayList<>();
        for(int i=0;i<n3-1;i++){
            arrl.add(split.sc.nextInt());
        }
         System.out.println("Enter the date(dd/mm/yyyy) :" );
         String date=split.sc.next();
         for(int i=0;i<arrl.size();i++){
            if(arrl.get(i)-1!=po){
                if(arrp[arrl.get(i)-1][po]==0){
                    arrp[po][arrl.get(i)-1]+=amt2;
                }
                else if(arrp[arrl.get(i)-1][po]!=0){
                    if(arrp[arrl.get(i)-1][po]>=amt2){
                        arrp[arrl.get(i)-1][po]-=amt2;
                    }
                    else if (arrp[arrl.get(i)-1][po]< amt2){
                        arrp[po][arrl.get(i)-1]=amt2-arrp[arrl.get(i)-1][po];
                    }
                }
        }
        }
         
        System.out.println("Bill added");
        str[po]+="\nBill added by you on "+ date+" for "+billfor+" of "+amt2;
        sp=new split();
        System.out.println("******************************************");
        sp.user(n,arrp,str,str1);
    }
    public void billpay(int n,int po,int arrp[][],String [] str,String[]str1){
        boolean flag=true;
        for(int i=0;i<arrp.length;i++){
            if(i!=po){
                if(arrp[i][po] !=0){
                    flag=false;
                    System.out.println("Bill :"+arrp[i][po]);
                    System.out.println("By :"+split.userlist.get(i).name);
                    System.out.println("If you want to pay : 1");
                    System.out.println("Exit : 2");
                    int b=split.sc.nextInt();
                    if(b==1){
                        System.out.println("Bill  payed");
                        str[po]+="\nBill payed by you for "+split.userlist.get(i).name;
                        str1[i]+="\nBill payed by "+ split.userlist.get(po).name+" to "+split.userlist.get(i).name +" of "+arrp[i][po];
                        arrp[i][po]=0;
                    }
                    else if(b==2){
                        continue;
                    }
                }
            }
        }
        if(flag==false){
            sp=new split();
            sp.user(n,arrp,str,str1);
        }
        if(flag){
            System.out.println("No friend has been Request for Repay");
             System.out.println("******************************************");
             sp=new split();
             sp.user(n,arrp,str,str1);
        }
        }
        
    
    public void billtransactions(int n,int arrp[][],int po,String [] str,String[]str1){
        if(str[po].equals(" ")){
            System.out.println("No transactions");
        }
        else{
            System.out.println(str[po]);
        }
        sp=new split();
        sp.user(n,arrp,str,str1);
    }
    public void results(int n,int arrp[][],int po,String [] str,String[]str1){
        if(str1[po].equals(" ")){
            System.out.println("No payments");
        }
        else{
            System.out.println(str1[po]);
        }
        sp=new split();
        sp.user(n,arrp,str,str1);
    }
    private static Object resizeArray (Object oldArray, int newSize) {
        int oldSize = java.lang.reflect.Array.getLength(oldArray);
        Class elementType = oldArray.getClass().getComponentType();
        Object newArray = java.lang.reflect.Array.newInstance(
              elementType, newSize);
        int preserveLength = Math.min(oldSize, newSize);
        if (preserveLength > 0)
           System.arraycopy(oldArray, 0, newArray, 0, preserveLength);
        return newArray; }
    public void billnewmember(int n,int arrp[][],int po1,String [] str,String[]str1){
        System.out.println("Enter the name of the members :");
        String name=split.sc.next();
        boolean flag=true;
        int y1=1;
        for(split i:split.userlist){
            if(i.name.equals(name)){
                flag=false;
                break;
            }
            y1++;
        }
        if(flag){
            System.out.println("Please enter password: ");
            String pass=split.sc.next();
            split.userlist.add(new split(name, Integer.toString(y1), pass));
            arrp = (int[][])resizeArray(arrp, n+1);
            for (int i=0; i<arrp.length; i++) {
            if (arrp[i] == null){
                arrp[i] = new int[30];
            }
                
            else{
             arrp[i] = (int[])resizeArray(arrp[i], n+1);
             }
             }
        }
        else{
            System.out.println("this user name is already exists");
            sp=new split();
            sp.user(n,arrp,str,str1);
        }
        System.out.println("Added Successfully ");
        System.out.println("Their user number is "+(y1));
        
        System.out.println("******************************************");
        sp=new split();
        sp.user(n,arrp,str,str1);
    }

}
