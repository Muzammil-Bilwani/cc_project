/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc_project.validations;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author hii
 */
public class keywords {
    
    List<String> keywords_list = new ArrayList<>();
    
    public keywords() throws FileNotFoundException{
    
        File keywords_file = new File("Keywords.txt");
        System.out.println(keywords_file.getPath());
        
        Scanner in = new Scanner(keywords_file);
        while(in.hasNext())
        {
            keywords_list.add(in.next());
        
        }
        
        for (String keywords_list1 : keywords_list) {
            System.out.println(keywords_list1);
        }
        
        in.close();
        
    }
    
}
