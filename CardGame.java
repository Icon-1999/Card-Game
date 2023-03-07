import java.util.concurrent.SubmissionPublisher;
import java.util.*;

import tools.*;

public class CardGame {

    LinkedList<Integer> UserCards = new LinkedList<>();
    LinkedList<Integer> ComputerCards = new LinkedList<>();
    LinkedList<Integer> UserScore = new LinkedList<>();
    LinkedList<Integer> ComputerScore = new LinkedList<>();
    List<Integer> Numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);  
    Random rnd = new Random();

int arr[][][] = {
    //Helmet
    {{91,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,91,},

    {93,122,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,122,94,},
        
    {93,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,94,},
        
    {93,0,0,0,0,0,0,92,92,92,92,92,92,0,0,0,0,0,0,94,},
        
    {93,0,0,0,0,92,95,95,86,86,55,55,95,95,92,0,0,0,0,94,},
        
    {93,0,0,92,95,95,122,0,71,87,87,54,0,122,95,95,92,0,0,94,},
        
    {93,0,92,91,122,0,0,0,83,83,61,61,0,0,0,122,91,92,0,94,},
        
    {93,0,91,91,92,92,92,92,92,91,91,92,92,92,92,92,91,91,0,94,},
        
    {93,0,91,95,0,0,0,0,95,91,91,95,0,0,0,0,95,91,0,94,},
        
    {93,0,93,0,0,0,0,0,0,95,95,0,0,0,0,0,0,94,0,94,},
        
    {93,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,94,},
        
    {93,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,94,},
        
    {93,122,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,122,94,},
        
    {91,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,91,}
    },

    //Shield
    {{91,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,91},

    {93,122,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,122,94},

    {93,0,0,0,0,92,91,91,91,91,91,91,91,91,92,0,0,0,0,94},

    {93,0,0,92,91,95,95,95,95,82,82,95,95,95,95,91,92,0,0,94},

    {93,0,94,91,95,0,122,0,0,58,58,0,0,122,0,95,91,93,0,94},

    {93,0,91,93,0,0,92,95,95,95,95,95,95,92,0,0,94,91,0,94},

    {93,94,91,70,77,77,93,0,86,68,68,55,0,94,77,77,53,91,93,94},

    {93,94,91,70,77,77,93,0,83,68,68,61,0,94,77,77,53,91,93,94},

    {93,0,91,93,0,0,95,92,92,92,92,92,92,95,0,0,94,91,0,94},

    {93,0,94,91,92,0,122,0,0,58,58,0,0,122,0,92,91,93,0,94},

    {93,0,0,95,91,92,92,92,92,80,80,92,92,92,92,91,95,0,0,94},

    {93,0,0,0,0,95,91,91,91,91,91,91,91,91,95,0,0,0,0,94},

    {93,122,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,122,94},

    {91,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,91}
    },

    //Sword
    {{91,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,91},

    {93,122,0,0,0,0,0,0,0,91,91,0,0,0,0,0,0,3,122,94},
    
    {93,0,0,0,0,0,0,0,91,82,82,91,0,0,0,0,0,0,0,94},
    
    {93,0,0,0,0,0,0,94,122,58,58,122,93,0,0,0,0,0,0,94},
    
    {93,0,0,0,0,0,0,94,0,58,58,51,93,0,0,0,0,0,0,94},
    
    {93,0,0,0,0,0,0,94,0,58,58,51,93,0,0,0,0,0,0,94},
    
    {93,0,0,0,0,0,0,94,0,58,58,51,93,0,0,0,0,0,0,94},
    
    {93,0,0,0,0,0,0,94,0,58,58,0,93,0,0,0,0,0,0,94},
    
    {93,0,0,0,0,0,0,94,122,58,58,122,93,0,0,0,0,0,0,94},
    
    {93,0,0,0,126,92,92,91,92,58,58,92,91,92,92,126,0,0,0,94},
    
    {93,0,0,0,0,0,0,0,0,91,91,0,0,0,0,0,0,0,0,94},
    
    {93,0,0,0,0,0,0,0,0,91,91,0,0,0,0,0,0,0,0,94},
    
    {93,122,0,0,0,0,0,0,0,126,126,0,0,0,0,0,0,0,122,94},

    {91,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,91}
    },

    //Bow&Arrow
    {{91,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,91},

    {93,122,0,0,0,0,0,92,92,92,0,0,0,0,0,0,0,4,122,94},

    {93,0,0,0,0,0,0,51,122,0,95,92,0,0,0,0,0,0,0,94},

    {93,0,0,0,0,0,0,51,0,0,0,0,95,92,0,0,0,0,0,94},

    {93,0,0,0,0,0,0,51,0,0,0,0,0,95,93,0,0,0,0,94},

    {93,0,72,56,0,0,0,51,0,0,0,0,0,122,94,0,0,56,0,94},

    {93,0,77,77,77,77,77,77,77,77,77,77,77,77,94,77,77,77,112,94},

    {93,0,73,62,0,0,0,51,0,0,0,0,0,122,94,0,0,62,0,94},

    {93,0,0,0,0,0,0,51,0,0,0,0,0,92,93,0,0,0,0,94},

    {93,0,0,0,0,0,0,51,0,0,0,0,92,95,0,0,0,0,0,94},

    {93,0,0,0,0,0,0,51,122,0,92,95,0,0,0,0,0,0,0,94},

    {93,0,0,0,0,0,0,95,95,95,0,0,0,0,0,0,0,0,0,94},

    {93,122,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,122,94},

    {91,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,91}
    },

    //Hammer
    {{91,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,91},

    {93,122,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,122,94},

    {93,0,0,0,0,0,0,0,0,92,92,0,0,0,0,0,0,0,0,94},

    {93,0,0,92,95,95,95,95,95,95,95,95,95,95,95,95,92,0,0,94},

    {93,0,91,0,122,0,0,85,77,86,55,77,56,0,0,122,0,91,0,94},

    {93,0,91,0,0,0,0,88,77,58,58,77,88,0,0,0,0,91,0,94},

    {93,0,91,0,122,0,0,84,77,83,61,77,62,0,0,122,0,91,0,94},

    {93,0,0,95,92,92,92,92,92,92,92,92,92,92,92,92,95,0,0,94},

    {93,0,0,0,0,0,0,0,95,91,91,95,0,0,0,0,0,0,0,94},

    {93,0,0,0,0,0,0,0,0,91,91,0,0,0,0,0,0,0,0,94},

    {93,0,0,0,0,0,0,0,0,91,91,0,0,0,0,0,0,0,0,94},

    {93,0,0,0,0,0,0,0,0,126,126,0,0,0,0,0,0,0,0,94},

    {93,122,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,122,94},

    {91,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,91},
    },

    //Axe
    {
        {91,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,91},

        {93, 122, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 122, 94}, 

        {93, 0, 0, 0, 0, 126, 126, 0, 0, 0, 0, 0, 0, 92, 92, 0, 0, 0, 0, 94}, 

        {93, 0, 0, 0, 72, 78, 78, 91, 95, 95, 95, 95, 95, 0, 91, 93, 0, 0, 0, 94},
        
        {93, 0, 0, 0, 73, 78, 78, 91, 92, 122, 0, 84, 86, 55, 122, 91, 0, 0, 0, 94}, 

        {93, 0, 0, 0, 0, 58, 58, 0, 0, 95, 92, 122, 83, 61, 56, 91, 0, 0, 0, 94}, 

        {93, 0, 0, 0, 0, 58, 58, 0, 0, 0, 0, 91, 93, 0, 0, 91, 0, 0, 0, 94}, 

        {93, 0, 0, 0, 0, 58, 58, 0, 0, 0, 0, 0, 94, 0, 122, 93, 0, 0, 0, 94}, 

        {93, 0, 0, 0, 0, 58, 58, 0, 0, 0, 0, 92, 91, 92, 91, 0, 0, 0, 0, 94}, 

        {93, 0, 0, 0, 0, 58, 58, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 94}, 

        {93, 0, 0, 0, 0, 58, 58, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 94}, 

        {93, 0, 0, 0, 0, 58, 58, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 94}, 

        {93, 122, 0, 0, 0, 91, 91, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 122, 94},

        {91,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,91},
    },

    //Boat
    {{91,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,91,},

    {93,122,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,7,122,94,},

    {93,0,0,0,0,0,0,0,0,122,0,0,0,0,0,0,0,0,0,94,},

    {93,0,0,0,0,0,0,0,0,76,59,0,0,0,0,0,0,0,0,94,},

    {93,0,0,0,0,0,0,0,0,58,72,56,0,0,0,0,0,0,0,94,},

    {93,0,0,0,0,0,0,0,0,58,0,52,0,0,0,0,0,0,0,94,},

    {93,0,0,0,0,0,0,0,0,58,0,52,0,0,0,0,122,73,77,94,},

    {93,0,55,0,0,0,0,0,0,58,73,62,0,0,0,0,85,73,60,94,},

    {93,0,92,92,0,0,0,0,0,58,60,0,0,0,0,0,94,61,0,94,},

    {93,0,122,91,91,92,105,92,92,58,105,92,92,105,92,91,91,122,0,94,},

    {93,0,85,57,95,91,91,91,91,91,91,91,91,91,91,95,0,0,0,94,},

    {93,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,94,},

    {93,122,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,122,94,},

    {91,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,91,}
    },

    //Star
    {{91,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,91,},

    {93,122,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,122,94,},
    
    {93,0,0,0,126,0,0,0,0,92,92,0,0,0,0,92,95,92,0,94,},
    
    {93,0,0,126,0,0,0,0,94,91,91,93,0,0,0,95,92,95,0,94,},
    
    {93,0,0,0,0,0,0,92,91,0,0,91,92,0,0,0,0,0,0,94,},
    
    {93,0,0,0,0,92,95,91,0,0,0,0,91,95,92,0,0,0,0,94,},
    
    {93,0,92,92,95,92,91,0,0,0,0,0,0,91,92,95,92,92,0,94,},
    
    {93,0,95,95,92,95,91,0,0,0,0,0,0,91,95,92,95,95,0,94,},
    
    {93,0,0,0,0,95,92,91,0,0,0,0,91,92,95,0,0,0,0,94,},
    
    {93,0,0,0,0,0,0,95,91,0,0,91,95,0,0,0,0,0,0,94,},
    
    {93,0,92,95,92,0,0,0,94,91,91,93,0,0,0,0,126,0,0,94,},
    
    {93,0,95,92,95,0,0,0,0,95,95,0,0,0,0,126,0,0,0,94,},
    
    {93,122,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,122,94,},
    
    {91,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,91,}
    },

    {{91,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,91,},

    {93,122,0,0,72,75,60,0,0,0,0,0,0,72,75,60,0,9,122,94,},        
    
    {93,0,0,0,0,91,0,56,92,92,92,92,85,0,91,0,0,0,0,94,},
    
    {93,0,0,0,91,0,95,95,95,0,0,95,95,95,0,91,0,0,0,94,},    
    
    {93,73,60,94,0,0,0,92,0,0,0,0,92,0,0,0,93,72,59,94,},    
    
    {93,72,94,91,0,0,94,91,93,0,0,94,91,93,0,0,91,93,60,94,},
    
    {93,73,94,91,0,0,0,95,0,0,0,0,95,0,0,0,91,93,59,94,},
    
    {93,0,0,94,0,91,91,85,0,77,77,0,56,91,91,0,93,0,0,94,},
    
    {93,0,0,0,91,95,94,85,0,77,77,0,56,93,95,91,0,0,0,94,},
    
    {93,0,0,0,94,0,93,92,92,0,0,92,92,94,0,93,0,0,0,94,},
    
    {93,0,0,0,0,91,95,92,92,91,91,92,92,95,91,0,0,0,0,94,},
    
    {93,0,0,0,0,95,92,92,92,92,92,92,92,92,95,0,0,0,0,94,},
    
    {93,122,0,0,0,0,0,95,95,0,0,95,95,0,0,0,0,0,122,94,},
    
    {91,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,91,}
    },

    //tree
    {{91,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,91,},
                                                               
    {93,122,0,0,92,92,92,92,92,92,92,92,92,92,92,92,10,-1,122,94,},  
    
    {93,0,0,91,73,122,72,122,60,72,73,60,73,60,60,60,91,0,0,94,},
    
    {93,0,91,0,59,73,72,72,59,59,72,122,60,60,59,73,0,91,0,94,}, 
    
    {93,94,0,72,72,59,122,73,72,59,73,60,59,72,73,60,73,0,93,94,},
    
    {93,94,72,73,73,72,94,92,0,72,60,60,92,93,60,122,59,60,93,94,},
    
    {93,94,122,72,60,59,0,94,93,0,0,94,93,122,60,72,59,122,93,94,},
    
    {93,94,0,0,0,122,0,0,93,0,94,94,0,0,0,0,0,0,93,94,},
    
    {93,94,0,0,126,0,0,0,93,0,94,94,0,0,0,126,0,0,93,94,},
    
    {93,94,0,126,0,126,0,0,93,0,0,94,0,0,126,0,126,0,93,94,},
    
    {93,0,91,0,0,0,0,94,0,0,0,93,93,0,0,0,0,91,0,94,},
    
    {93,0,0,91,0,92,91,95,0,0,0,0,95,91,92,0,91,0,0,94,},
    
    {93,122,0,0,95,95,95,95,95,95,95,95,95,95,95,95,0,0,122,94,},
    
    {91,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,91,}
    }

};

String fcolor[][][] = {
    //Helmet
    { {Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.WHITE,Colors.BLACK_BOLD,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK_BOLD,Colors.WHITE,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.WHITE,Colors.WHITE,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.WHITE,Colors.WHITE,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.WHITE,Colors.WHITE,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.WHITE,Colors.BLACK_BOLD,Colors.WHITE,Colors.WHITE,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK},
    },

    //Sheild
   { {Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.GREEN,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.BLACK,Colors.BLACK},

    {Colors.BLACK,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.BLACK},

    {Colors.BLACK,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.BLACK},

    {Colors.BLACK,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.BLACK},

    {Colors.BLACK,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.BLACK},

    {Colors.BLACK,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.BLACK},

    {Colors.BLACK,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.BLACK},

    {Colors.BLACK,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.BLACK},

    {Colors.BLACK,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.BLACK},

    {Colors.BLACK,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.BLACK},

    {Colors.BLACK,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.RED,Colors.BLACK,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK},
    },
    
    //Sword
    { {Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.GREEN,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK,Colors.BLACK},

    {Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK,Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK},

    {Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK},

    {Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK},

    {Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK},

    {Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK},

    {Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK},

    {Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK},
//
    {Colors.BLACK,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.BLACK,Colors.BLACK,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.BLACK},

    {Colors.BLACK,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.BLACK},

    {Colors.BLACK,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.CYAN,Colors.BLACK,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK},
    },

    //Bow&Arrow
    { {Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.YELLOW,Colors.YELLOW,Colors.YELLOW,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.YELLOW,Colors.YELLOW,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.YELLOW,Colors.YELLOW,Colors.YELLOW,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.YELLOW,Colors.YELLOW,Colors.YELLOW,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.YELLOW,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.YELLOW,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.YELLOW,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.YELLOW,Colors.YELLOW,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.YELLOW,Colors.YELLOW,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.YELLOW,Colors.YELLOW,Colors.YELLOW,Colors.YELLOW,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.YELLOW,Colors.YELLOW,Colors.YELLOW,Colors.YELLOW,Colors.YELLOW,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.YELLOW,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK},
    },

    //Hammer
    { {Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.GREEN,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK,Colors.BLACK},

    {Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK,Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK},

    {Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK},

    {Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK},

    {Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK},

    {Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK},

    {Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK},
    },

    //Axe
    { {Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK},

    {Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK},

    {Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK},

    {Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK},

    {Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK},

    {Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK,Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK},

    {Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK,Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK,Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK},

    {Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK,Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK},

    {Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK,Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK},

    {Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK,Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK},

    {Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK,Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK},

    {Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK,Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK},

    {Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK,Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK},
    },

    //Boat
    { {Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.WHITE,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.WHITE,Colors.WHITE,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.WHITE,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.WHITE,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK_BOLD,Colors.BLACK,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.WHITE,Colors.WHITE,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.WHITE,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK,Colors.BLACK_BOLD,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK_BOLD,Colors.BLACK,Colors.BLACK,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK},
    },

    //Star
    { {Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK},

    {Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK},

    {Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK},

    {Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK},

    {Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK},

    {Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK},

    {Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK},

    {Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK},

    {Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK},

    {Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK},

    {Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK},

    {Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK},

    {Colors.BLACK,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.WHITE,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK},
    },

    //Dragon
    { {Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK},

    {Colors.BLACK,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.BLACK},

    {Colors.BLACK,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.BLACK_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.BLACK_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.BLACK},

    {Colors.BLACK,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.BLACK,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.BLACK,Colors.BLACK,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.BLACK,Colors.CYAN,Colors.BLACK,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.BLACK,Colors.CYAN,Colors.BLACK,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.BLACK_BOLD,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.BLACK,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.BLACK,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.BLACK_BOLD,Colors.BLACK},

    {Colors.BLACK,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.BLACK},

    {Colors.BLACK,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.BLACK},

    {Colors.BLACK,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.BLACK},

    {Colors.BLACK,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.BLACK},

    {Colors.BLACK,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.BLACK},

    {Colors.BLACK,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.GREEN_BOLD,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK},
    },

    //Tree
    { {Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.YELLOW,Colors.YELLOW,Colors.YELLOW,Colors.YELLOW,Colors.YELLOW,Colors.YELLOW,Colors.YELLOW,Colors.YELLOW,Colors.YELLOW,Colors.YELLOW,Colors.YELLOW,Colors.YELLOW,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.YELLOW,Colors.GREEN,Colors.YELLOW,Colors.GREEN,Colors.YELLOW,Colors.GREEN,Colors.GREEN,Colors.GREEN,Colors.GREEN,Colors.GREEN,Colors.GREEN,Colors.GREEN,Colors.GREEN,Colors.YELLOW,Colors.YELLOW,Colors.BLACK_BOLD,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK_BOLD,Colors.YELLOW,Colors.GREEN,Colors.GREEN,Colors.GREEN,Colors.GREEN,Colors.GREEN,Colors.GREEN,Colors.GREEN,Colors.GREEN,Colors.YELLOW,Colors.GREEN,Colors.GREEN,Colors.GREEN,Colors.GREEN,Colors.GREEN,Colors.YELLOW,Colors.YELLOW,Colors.BLACK},

    {Colors.BLACK,Colors.YELLOW,Colors.GREEN,Colors.GREEN,Colors.GREEN,Colors.GREEN,Colors.YELLOW,Colors.GREEN,Colors.GREEN,Colors.GREEN,Colors.GREEN,Colors.GREEN,Colors.GREEN,Colors.GREEN,Colors.GREEN,Colors.GREEN,Colors.GREEN,Colors.GREEN,Colors.YELLOW,Colors.BLACK},

    {Colors.BLACK,Colors.YELLOW,Colors.GREEN,Colors.GREEN,Colors.GREEN,Colors.GREEN,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.GREEN,Colors.GREEN,Colors.GREEN,Colors.GREEN,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.GREEN,Colors.YELLOW,Colors.GREEN,Colors.GREEN,Colors.YELLOW,Colors.BLACK},

    {Colors.BLACK,Colors.YELLOW,Colors.YELLOW,Colors.GREEN,Colors.GREEN,Colors.GREEN,Colors.GREEN,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.GREEN,Colors.GREEN,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.YELLOW,Colors.GREEN,Colors.GREEN,Colors.GREEN,Colors.YELLOW,Colors.YELLOW,Colors.BLACK},

    {Colors.BLACK,Colors.YELLOW,Colors.YELLOW,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.YELLOW,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.YELLOW,Colors.BLACK},

    {Colors.BLACK,Colors.YELLOW,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.YELLOW,Colors.YELLOW,Colors.YELLOW,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.YELLOW,Colors.BLACK},

    {Colors.BLACK,Colors.YELLOW,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.YELLOW,Colors.YELLOW,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK_BOLD,Colors.YELLOW,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.YELLOW,Colors.YELLOW,Colors.BLACK_BOLD,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.YELLOW,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.YELLOW,Colors.YELLOW,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.YELLOW,Colors.YELLOW,Colors.YELLOW,Colors.YELLOW,Colors.YELLOW,Colors.YELLOW,Colors.YELLOW,Colors.YELLOW,Colors.YELLOW,Colors.YELLOW,Colors.YELLOW,Colors.YELLOW,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK_BOLD,Colors.BLACK},

    {Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK,Colors.BLACK},
    },

};

String bcolor[][][] = {
    //Helmet
    { {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},
    },

    //Shield
    { {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

     {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

     {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

     {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

     {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

     {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

     {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

     {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

     {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

     {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

     {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.YELLOW_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

     {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

     {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

     {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},
    },

    //Sword
    { {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

     {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

     {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

     {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

     {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

     {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

     {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

     {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

     {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

     {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

     {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

     {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

     {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

     {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},
    },

    //Bow&Arrow
    { {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

     {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

     {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

     {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

     {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

     {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

     {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

     {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

     {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

     {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

     {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

     {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

     {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

     {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},
    },

    //Hammer
    { {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},
    },

    //Axe
    { {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},
    },

    //Boat
    { {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},
    },

    //Star
    { {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.WHITE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},
    },

    //Dragon
    { {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.GREEN_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND},
    },
    //Tree
    { {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLACK},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLACK},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLACK},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLACK},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLACK},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLACK},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLACK},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLACK},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLACK},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLACK},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLACK},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLACK_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLACK},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLACK},

    {Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLUE_BACKGROUND,Colors.BLACK},
    },
};

    int scoreArr[][][] = {
        //0
        {
            {0, 91, 91, 0},
            {91, 0, 92, 91},
            {91, 95, 0, 91},
            {0, 91, 91, 0},
        },
        //1
        {
            {0, 0, 92, 0},
            {0, 95, 91, 0},
            {0, 0, 91, 0},
            {0, 92, 91, 92},
        },

        //2
        {
            {0, 92, 92, 0},
            {95, 0, 0, 92},
            {0, 92, 95, 0},
            {91, 92, 92, 92},
        },

        //3
        {
            {0, 92, 92, 0},
            {95, 0, 92, 95},
            {92, 0, 95, 92},
            {0, 95, 95, 0},
        },
        //4
        {
            {91, 0, 0, 91},
            {91, 0, 0, 91},
            {95, 95, 95, 91},
            {0, 0, 0, 91},
        },
        //5
        {
            {91, 95, 95, 95},
            {91, 92, 95, 92},
            {92, 0, 0, 91},
            {95, 92, 92, 95},
        },

    };

    String scorefColor[][][] = {
        {
            {Colors.WHITE, Colors.WHITE, Colors.WHITE, Colors.WHITE},
            {Colors.WHITE, Colors.WHITE, Colors.WHITE, Colors.WHITE},
            {Colors.WHITE, Colors.WHITE, Colors.WHITE, Colors.WHITE},
            {Colors.WHITE, Colors.WHITE, Colors.WHITE, Colors.WHITE},
        },

        {
            {Colors.WHITE, Colors.WHITE, Colors.WHITE, Colors.WHITE},
            {Colors.WHITE, Colors.WHITE, Colors.WHITE, Colors.WHITE},
            {Colors.WHITE, Colors.WHITE, Colors.WHITE, Colors.WHITE},
            {Colors.WHITE, Colors.WHITE, Colors.WHITE, Colors.WHITE},
        },

        {
            {Colors.WHITE, Colors.WHITE, Colors.WHITE, Colors.WHITE},
            {Colors.WHITE, Colors.WHITE, Colors.WHITE, Colors.WHITE},
            {Colors.WHITE, Colors.WHITE, Colors.WHITE, Colors.WHITE},
            {Colors.WHITE, Colors.WHITE, Colors.WHITE, Colors.WHITE},
        },

        {
            {Colors.WHITE, Colors.WHITE, Colors.WHITE, Colors.WHITE},
            {Colors.WHITE, Colors.WHITE, Colors.WHITE, Colors.WHITE},
            {Colors.WHITE, Colors.WHITE, Colors.WHITE, Colors.WHITE},
            {Colors.WHITE, Colors.WHITE, Colors.WHITE, Colors.WHITE},
        },

        {
            {Colors.WHITE, Colors.WHITE, Colors.WHITE, Colors.WHITE},
            {Colors.WHITE, Colors.WHITE, Colors.WHITE, Colors.WHITE},
            {Colors.WHITE, Colors.WHITE, Colors.WHITE, Colors.WHITE},
            {Colors.WHITE, Colors.WHITE, Colors.WHITE, Colors.WHITE},
        },

        {
            {Colors.WHITE, Colors.WHITE, Colors.WHITE, Colors.WHITE},
            {Colors.WHITE, Colors.WHITE, Colors.WHITE, Colors.WHITE},
            {Colors.WHITE, Colors.WHITE, Colors.WHITE, Colors.WHITE},
            {Colors.WHITE, Colors.WHITE, Colors.WHITE, Colors.WHITE},
        },

    };

    String scorebColor[][][] = {
        {
            {Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND},
            {Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND},
            {Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND},
            {Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND},
        },

        {
            {Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND},
            {Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND},
            {Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND},
            {Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND},
        },

        {
            {Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND},
            {Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND},
            {Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND},
            {Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND},
        },

        {
            {Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND},
            {Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND},
            {Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND},
            {Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND},
        },

        {
            {Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND},
            {Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND},
            {Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND},
            {Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND},
        },

        {
            {Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND},
            {Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND},
            {Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND},
            {Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND, Colors.BLACK_BACKGROUND},
        },
    };

    public void cls(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    public static void printxy(int col, int row, String val){
        char escCode = 0x1B;
        System.out.print(String.format("%s[%d;%df",escCode,row,col));
        System.out.print(val);
    }

    void DisplayCard(int x, int y, int cardNumber)
    {
        for (int i=0; i < 14; i++)
        {
            for (int j=0; j < 20; j++)
            {
                if (arr[cardNumber][i][j] == 0)
                    //System.out.print(fcolor[cardNumber][i][j] + bcolor[cardNumber][i][j] + " ");
                    printxy(x+j,y+i,fcolor[cardNumber][i][j] + bcolor[cardNumber][i][j] + " ");
                else if (arr[cardNumber][i][j] == 10)
                    printxy(x+j,y+i,fcolor[cardNumber][i][j] + bcolor[cardNumber][i][j] + "1");
                else if (arr[cardNumber][i][j] == -1)
                    printxy(x+j,y+i,fcolor[cardNumber][i][j] + bcolor[cardNumber][i][j] + "0");
                else if (arr[cardNumber][i][j] >0 && arr[cardNumber][i][j] < 10)
                    //System.out.print(fcolor[cardNumber][i][j] + bcolor[cardNumber][i][j] + String.valueOf(arr[cardNumber][i][j]));
                    printxy(x+j,y+i,fcolor[cardNumber][i][j] + bcolor[cardNumber][i][j] + String.valueOf(arr[cardNumber][i][j]));
                else
                    //System.out.print(fcolor[cardNumber][i][j] + bcolor[cardNumber][i][j] +Symbols.EXTENDED[arr[cardNumber][i][j]]);
                    printxy(x+j,y+i,fcolor[cardNumber][i][j] + bcolor[cardNumber][i][j] +Symbols.EXTENDED[arr[cardNumber][i][j]]);
            }
            System.out.println(" ");
        }
    }

    void displayScore(int x, int y, int scoreNumber){
            for (int i=0; i < 4; i++)
            {
                for (int j=0; j < 4; j++)
                {
                    if (scoreArr[scoreNumber][i][j] == 0)
                        //System.out.print(fcolor[cardNumber][i][j] + bcolor[cardNumber][i][j] + " ");
                        printxy(x+j,y+i,scorefColor[scoreNumber][i][j] + scorebColor[scoreNumber][i][j] + " ");
                    else if (arr[scoreNumber][i][j] >0 && arr[scoreNumber][i][j] < 10)
                        //System.out.print(fcolor[cardNumber][i][j] + bcolor[cardNumber][i][j] + String.valueOf(arr[cardNumber][i][j]));
                        printxy(x+j,y+i,scorefColor[scoreNumber][i][j] + scorebColor[scoreNumber][i][j] + String.valueOf(scoreArr[scoreNumber][i][j]));
                    else
                        //System.out.print(fcolor[cardNumber][i][j] + bcolor[cardNumber][i][j] +Symbols.EXTENDED[arr[cardNumber][i][j]]);
                        printxy(x+j,y+i,scorefColor[scoreNumber][i][j] + scorebColor[scoreNumber][i][j] +Symbols.EXTENDED[scoreArr[scoreNumber][i][j]]);
                }
            }
    }

    void NumberShuffle(List<Integer> Nums){
        Collections.shuffle(Nums);
    }

    int GetCompPick(){
        int pick;
        pick = rnd.nextInt(11);
        return pick;
    }

    void printCard(int x, int y, LinkedList<Integer> Num){
        for (int i = 0; i < Num.size(); i++) {
            //printxy(x,y,Num.get(i).toString());
            DisplayCard(x,y,Num.get(i) - 1);
            x=x+20;
            //System.out.println(Num.get(i));
        }
    }

    void displayDeck(){
        cls();
        printxy(5, 0, "COMPUTER");
        printCard(5, 3, ComputerCards);
        printCard(5, 20, UserCards);
        printxy(5, 37, "The highest card wins. Pick a card to play in your deck. ");
        printxy(5, 35, "USER --> ");
    }

    public void Play(){
        cls();

        Integer UserInput;
        Integer CompInput;
        int ShuffleNum, Upoints = 0, Cpoints = 0;

        NumberShuffle(Numbers);

        

        //Cards
        for(int i = 0; i < 5; ++i){
            ShuffleNum = Numbers.get(i);
            UserCards.add(ShuffleNum);
        }

        for(int i = 5; i < 10; ++i){
            ShuffleNum = Numbers.get(i);
            ComputerCards.add(ShuffleNum);
        }

        //Score
        for(int i = 0; i < 6; ++i){
            UserScore.add(i);
        }

        for(int i = 0; i < 6; ++i){
            ComputerScore.add(i);
        }

        displayDeck();

        displayScore(131, 3, Cpoints);
        displayScore(131, 30, Upoints);

        Scanner input = new Scanner(System.in);
        while (!UserCards.isEmpty() || !ComputerCards.isEmpty()){
            printxy(5, 35, "USER --> ");
            UserInput = input.nextInt();
            while(!UserCards.contains(UserInput)){
                printxy(5, 36, "Invalid Input. Please pick from your deck. --> ");
                UserInput = input.nextInt();
                displayDeck();
            }
            UserCards.remove(UserInput);
            displayDeck();
            
            CompInput = GetCompPick();
            while(!ComputerCards.contains(CompInput)){
                CompInput = GetCompPick();
            }
            ComputerCards.remove(CompInput);
            displayDeck();

            DisplayCard(113,12,UserInput-1);
            DisplayCard(133,12,CompInput-1);

            if (UserInput > CompInput){
                Upoints++;
                displayScore(131, 3, Cpoints);
                displayScore(131, 30, Upoints);
            }
            else{
                Cpoints++;
                displayScore(131, 3, Cpoints);
                displayScore(131, 30, Upoints);
            }
        }

        if (Upoints == 5){
            printxy(5, 35, "You Win! Perfect!!!");
        }
        else if (Upoints > Cpoints){
            printxy(5, 35, "You Win!");
        }
        else{
            printxy(5, 35, "You Lose. Try Again");
        }

        printxy(5, 37, "GAME OVER!!!                                                             ");
    }
}