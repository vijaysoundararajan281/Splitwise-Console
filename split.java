package Split;
import java.util.*;
public class split {
    public static Scanner sc = new Scanner(System.in);
    static split sp;
    static BillAdd bill;
    String name;
    String userid;
    String pass;
    split (String name, String userid, String pass) {
        this.name = name;
        this.userid =userid;
        this.pass = pass;
    }
    public split() {
    }
    static List<split> userlist = new ArrayList<>();
    public static int n;
    public static int po1;
    public static String arr[][] =new String[2][n];
    public static String []arr1=new String[n];
    public static void system(int n,int[][] arrp,String[]str,String[]str1){
        String name;
        String pass;
        String id;
        for(int i=0;i<n;i++){
            System.out.println("Enter the name of the members :");
            name=sc.next();
            System.out.println("Please enter password: ");
            pass=sc.next();
            id=Integer.toString(i+1);
            po1=i+1;
            System.out.println("Their user number is "+id);
            userlist.add(new split(name, id, pass));
        }
        sp=new split();
        sp.user(n,arrp,str,str1);
    }
    public void user(int n,int arrp[][],String [] str,String[]str1){
        System.out.println("Please enter your user-id :");
        String us=sc.next();
        boolean flag=false;
        int po=0;
        for(split i:split.userlist){
            if(i.userid.equals(us)){
                flag=true;
                break;
            }
            po++;
        }
        if(flag){
            System.out.println("Please enter password :");
            String p=sc.next();
            if(split.userlist.get(po).pass.equals(p)){
                System.out.println("Please choose one option:");
                System.out.println("If you want to add the bill : 1");
                System.out.println("If you want to pay the bill : 2");
                System.out.println("If you want to add new member : 3");
                System.out.println("If you want to see the transactions : 4");
                System.out.println("If you want to see the results : 5");
                int cf=sc.nextInt();
                if(cf==1){
                     bill=new BillAdd();
                     bill.billadd(n,po,arrp,str,str1);
                     sp.user(n,arrp,str,str1);
                }
                else if(cf==2){
                    bill=new BillAdd();
                    bill.billpay(n,po,arrp,str,str1);
                    sp.user(n,arrp,str,str1);
                }
                else if(cf==3){
                    bill=new BillAdd();
                    bill.billnewmember(n,arrp,po1,str,str1);
                    sp.user(n,arrp,str,str1);
                }
                else if(cf==4){
                    bill=new BillAdd();
                    bill.billtransactions(n,arrp,po,str,str1);
                    sp.user(n,arrp,str,str1);
                }
                else if(cf==5){
                    bill=new BillAdd();
                    bill.results(n,arrp,po,str,str1);
                    sp.user(n,arrp,str,str1);
                }
                else if(cf==6){
                    sp.user(n,arrp,str,str1);
                }
                else{
                    System.out.println("Please enter the valid input");
                    sp.user(n,arrp,str,str1);
                }
            }
            else{
                System.out.println("Please enter valid password");
                sp.user(n,arrp,str,str1);
            }
        
    }
    else{
        System.out.println("Please enter valid user-id");
        sp.user(n,arrp,str,str1);
    }
    }
    public static void main(String[] args) {
        System.out.println("Please enter how many members:");
        n=sc.nextInt();
        int[][] arrp=new int[n][n];
        String [] str=new String[n];
        String [] str1=new String[n];
        Arrays.fill(str, " ");
        Arrays.fill(str1, " ");
        system(n,arrp,str,str1);
    }
}
