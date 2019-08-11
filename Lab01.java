package lab01;

import java.util.*;


class Company{
	
	private String Comp_name;
    private int Num_vacancy;
    private int Num_courses;
    private ArrayList<String> Courses;
    private int[] Placed;
	
	
	public int[] getPlaced() {
		return Placed;
	}
	public void setPlaced(int[] placed) {
		Placed = placed;
	}
	public int getNum_courses() {
		return Num_courses;
	}
	public void setNum_courses(int num_courses) {
		Num_courses = num_courses;
	}   
    public String getComp_name() {
		return this.Comp_name;
	}
	public void setComp_name(String Comp_name) {
		this.Comp_name = Comp_name;
	}
	public int getNum_vacancy() {
		return Num_vacancy;
	}
	public void setNum_vacancy(int Num_vacancy) {
		this.Num_vacancy = Num_vacancy;
	}
	public ArrayList<String> getCourses() {
		return this.Courses;
	}
	public void setCourses(ArrayList<String> Courses) {
		this.Courses = Courses;
	}  
}


class Student {
	
	private int Roll_no;
	private String Branch;
	private float Cgpa;
	private String Placement_status;
	private HashMap<String, Integer> Tech_score;
	private Dictionary<String, Integer> Tech_score_d;
	private String Company_placed;
	
	public Student() {
		Tech_score_d = new Hashtable<>();
		Tech_score = new HashMap<>();
	}
			
	public Dictionary<String, Integer> getTech_score_d() {
		return Tech_score_d;
	}
	public void setTech_score_d(String s, Integer i) {
		Tech_score_d.put(s, i);
	}
	public String getCompany_placed() {
		return Company_placed;
	}
	public void setCompany_placed(String company_placed) {
		Company_placed = company_placed;
	}
	public String getPlacement_status() {
		return this.Placement_status;
	}
	public void setPlacement_status(String placement_status) {
		this.Placement_status = placement_status;
	}
	public HashMap<String, Integer> getTech_score() {
		return this.Tech_score;
	}
	public void setTech_score(String s, Integer i) {
		this.Tech_score.put(s, i);
	}
	public int getRoll_no() {
		return this.Roll_no;
	}
	public void setRoll_no(int roll_no) {
		this.Roll_no = roll_no;
	}
	public String getBranch() {
		return this.Branch;
	}
	public void setBranch(String branch) {
		this.Branch = branch;
	}
	public float getCgpa() {
		return this.Cgpa;
	}
	public void setCgpa(float cgpa) {
		this.Cgpa = cgpa;
	} 
}   
    
public class Lab01{  
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);      
        int num_students = scan.nextInt();
        Student student; 
        Company company;
        ArrayList<Student> student_list = new ArrayList<Student>();
        ArrayList<Company> company_list = new ArrayList<Company>();
        
        
        for(int i=0;i<num_students;i++){
        	student = new Student();
        	float cgpa = scan.nextFloat();
            String branch = scan.next();
        	student.setBranch(branch);
            student.setCgpa(cgpa);
            student.setRoll_no(i+1);
            student.setPlacement_status("Unplaced");
            student.setCompany_placed("");
            student_list.add(student); 
            
            }
        
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        while(student_list.size()>0) {
        int query = scan.nextInt();
        if (query == 1){
        	company = new Company();
            String company_name_in = scan.next();
            company.setComp_name(company_name_in);
            
            System.out.print("Number of Eligible Courses = ");
            int num_eligiblecourses_in = scan.nextInt();
            company.setNum_courses(num_eligiblecourses_in);
            
            ArrayList<String> courses_list = new ArrayList<String>();
            for(int i=0;i<num_eligiblecourses_in;i++) {
            	String course_crit = scan.next();
            	courses_list.add(course_crit);
            }
            
            company.setCourses(courses_list);
            
            System.out.print("Number of Required Students = ");
            int num_required_in = scan.nextInt();
            company.setNum_vacancy(num_required_in);
            
            System.out.println(company.getComp_name());
            System.out.println("Course Criteria");
            for(int j=0;j<company.getNum_courses();j++) {
            	System.out.println(company.getCourses().get(j));
            }
            System.out.println("Number of Required Students = " + company.getNum_vacancy());
            if(company.getNum_vacancy()==0) {
            	System.out.println("Application Status = CLOSED");
            }
            else {
            	System.out.println("Application Status = OPEN");
            }
            company_list.add(company);
            System.out.println("Enter scores for the technical round.");
            
            for(int k = 0;k<company.getNum_courses();k++) {
            	for(int q = 0; q<student_list.size();q++) {
            		if(student_list.get(q).getBranch().equals(company.getCourses().get(k))) {
            			System.out.println("Enter score for Roll no." + student_list.get(q).getRoll_no());
            			int techscore = scan.nextInt();
            			student_list.get(q).setTech_score_d(company.getComp_name(), techscore);
            			student_list.get(q).setTech_score(company.getComp_name(), techscore);
            		}
             	}
            }            
        }
      
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////        
        
        if (query == 2){
            Iterator itr_s = student_list.iterator();
            int i = 0;
            while(itr_s.hasNext()){
            Student s= (Student)itr_s.next();
            if(s.getPlacement_status() == "Placed") {
            System.out.println("Accounts removed for ");
    System.out.println(s.getRoll_no());
            itr_s.remove();
                  }
            i++;
            }
            
            }
        
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////       
        
        if (query == 3){
            Iterator itr_c = company_list.iterator();
            
            while(itr_c.hasNext()){
            Company c=(Company)itr_c.next();
            if(c.getNum_vacancy() == 0) {
            System.out.println("Accounts removed for ");
        System.out.println(c.getComp_name());
            itr_c.remove();
            }
            
            }
            }
        
///////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
        
        if (query == 4){
        	
        	int Count_unplaced = 0;
        	int i = 0;
        	while(i<student_list.size()){
        		if(student_list.get(i).getPlacement_status() == "Unplaced") {
        			Count_unplaced++;
              	}
        		i++;
        	}
        	System.out.println(Count_unplaced + " students left.");
        }
        
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
        
        if (query == 5){
        	
        	int i = 0;
        	while(i<company_list.size()){
        		
        		if(company_list.get(i).getNum_vacancy() != 0) {
        			System.out.println(company_list.get(i).getComp_name());
        		}
        		i++;
           	}	
        }
      
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////        
        
        if (query == 6)
        {
        
        String company_name = scan.next();
        
        int i3 = 0;
        int x=0;
            while(i3<company_list.size())
            {
                if(company_list.get(i3).getComp_name().equals(company_name)) 
                {
        x = company_list.get(i3).getNum_vacancy();
        }
        i3++;
        }
                  
            ArrayList<Student> applied = new ArrayList<Student>();
            int[] arr = new int[x];
            int roll = 0;
            int tscore = -1;
            float gpa = -1;
            
        int i = 0;
            while(i<student_list.size())
            {
                if(student_list.get(i).getTech_score().containsKey(company_name) && student_list.get(i).getPlacement_status().equals("Unplaced")) 
                {
        applied.add(student_list.get(i));
        }
        i++;
        }
            
            System.out.println("Roll Number of Selected Students");

            for (int q=0;q<x;q++) 
            {
            
            int i1 = 0;
                 while(i1<applied.size())
                 {
                     if(applied.get(i1).getPlacement_status().equals("Unplaced")) 
                     {
 	       	if(applied.get(i1).getTech_score().get(company_name)>tscore) {
 	       	roll = applied.get(i1).getRoll_no();
 	           	tscore = applied.get(i1).getTech_score().get(company_name);
 	           	gpa = applied.get(i1).getCgpa();
 	       	
 	      }
 	       	
 	      else if(applied.get(i1).getTech_score().get(company_name)==tscore && applied.get(i1).getCgpa()>gpa) {
 	      roll = applied.get(i1).getRoll_no();
 	      gpa = applied.get(i1).getCgpa();	
 	      }
 	       	}
 	       	
 	       	i1++;
 	       	}
 	       	
       	System.out.println(roll);
       	arr[q] = roll;
       	
       	int i2 = 0;
                    while(i2<student_list.size())
                    {
       	if(student_list.get(i2).getRoll_no()==roll) {
       	
       	student_list.get(i2).setPlacement_status("Placed");
       	student_list.get(i2).setPlacement_status(company_name);
       	
               	}
       	}
                    i2++;
                    
                    int i31 = 0;
               	while(i31<company_list.size()){
               	if(company_list.get(i31).getComp_name() == company_name) {
               	company_list.get(i31).setNum_vacancy((company_list.get(i31).getNum_vacancy())-1);
               	}
               	i31++;
            }
            
        int i32 = 0;
            while(i32<company_list.size())
            {
                if(company_list.get(i32).getComp_name() == company_name) 
                {
        company_list.get(i32).setPlaced(arr);
        }
        i32++;
        }
        }
            
   }
           
        
        
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////        
        if (query == 7){
            String company_name = scan.next();
            
        	int i = 0;
        	while(i<company_list.size()){
        		if(company_list.get(i).getComp_name().equals(company_name)) {
        			System.out.println(company_list.get(i).getComp_name());
        			System.out.println("Course Criteria");
        			
                	int j = 0;
                	while(j<company_list.get(i).getCourses().size()) {
                		System.out.println(company_list.get(i).getCourses().get(j));
                		j++;
                	}
                	System.out.println(company_list.get(i).getNum_vacancy());
                	if(company_list.get(i).getNum_vacancy()==0) {
                		System.out.println("CLOSED");
                	}
                	else {
                		System.out.println("OPEN");
                	}
        		}
        		i++;
        	} 
        }
       
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////        
        
        if (query == 8){
            int roll_no = scan.nextInt();
           
        	int i = 0;
        	while(i<student_list.size()){
        		if(student_list.get(i).getRoll_no() == roll_no) {
        			System.out.println(student_list.get(i).getRoll_no());
        			System.out.println(student_list.get(i).getCgpa());
        			System.out.println(student_list.get(i).getBranch());
        			System.out.println(student_list.get(i).getPlacement_status());
        			if(student_list.get(i).getPlacement_status() == "Placed") {
        				System.out.println(student_list.get(i).getCompany_placed());
        				
        			}
        		}
        		i++;
        	} 
        }
       
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////        
        
        if(query == 9){
            int roll_no = scan.nextInt();
            boolean found = false;
        	int i = 0;
        	while(i<student_list.size()){
        		if(student_list.get(i).getRoll_no() == roll_no) {
        			found = true;
        			Enumeration<String> e = student_list.get(i).getTech_score_d().keys();
        	        while(e.hasMoreElements()) {
        	            String k = e.nextElement();
        	            System.out.println(k + " " + student_list.get(i).getTech_score_d().get(k));
        	        }
        	        break;
        		}
        		
        		i++;
        	}
        	if(!found) {
    			System.out.println("No student with the given roll number has an account.");
    		}
        }
        
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////        
    }           
    }
    }

