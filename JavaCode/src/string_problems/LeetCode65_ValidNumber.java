package string_problems;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 65, Level: Hard
 * 
 * https://leetcode.com/problems/valid-number/
 */
public class LeetCode65_ValidNumber {
    
	/* rules 1: "+" / "-" at index 0
	 * rules 2: only one point
	 * rules 3: only one e
	 * rules 4: only number and "e"
	 */
    public boolean isNumber(String s) {
        s = s.trim();
        
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        boolean numberAfterE = true;
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numberSeen = true;
                numberAfterE = true;
            } else if(s.charAt(i) == '.') {
                if(eSeen || pointSeen) {
                    return false;
                }
                pointSeen = true;
            } else if(s.charAt(i) == 'e') {
                if(eSeen || !numberSeen) {
                    return false;
                }
                numberAfterE = false;
                eSeen = true;
            } else if(s.charAt(i) == '-' || s.charAt(i) == '+') {
                if(i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }
        
        return numberSeen && numberAfterE;
    }
    
    // Function check valid number without e
    public boolean isNumber2(String s) {
        s = s.trim();
        
        boolean hasPoint = false;
        boolean hasNumber = false;
        boolean numberAfterPoint = true;
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                hasNumber = true;
                numberAfterPoint = true;
            }
            else if(s.charAt(i) == '.') {
                if(!hasNumber || hasPoint) {
                    return false;
                }
                hasPoint = true;
                numberAfterPoint = false;
            }
            else if(s.charAt(i) == '+' || s.charAt(i) == '-') {
                if(i != 0) {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        
        return numberAfterPoint;
    }
    
    public static void main(String[] args) {
    	LeetCode65_ValidNumber obj = new LeetCode65_ValidNumber();
    	
    	String[] testcase1 = {"1a", "+3.5", ".6", "711", "-0."};
    	
    	for(String test : testcase1) {
    		System.out.println(obj.isNumber2(test));
    	}
    	
    	System.out.println(obj.isNumber("-0."));
    }
}
