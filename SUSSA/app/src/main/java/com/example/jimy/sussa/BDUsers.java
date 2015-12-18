package com.example.jimy.sussa;

import java.util.HashMap;

/**
 * Created by Jimy on 16/12/15.
 */
public class BDUsers {
    static HashMap<String,User> hashUsers = createHashUsers();

    static HashMap createHashUsers(){
        HashMap<String,User> map = new HashMap();
        map.put("",new User("blank_name","","blank@unifesp.br","","BCTeste"));
        map.put("blank@unifesp.br",new User("blank_name","","blank@unifesp.br","","BCTeste"));
        map.put("aluno",new User("aluno","aluno","aluno@unifesp.br","unifesp","BCTeste"));
        map.put("aluno@unifesp.br",new User("aluno","","aluno@unifesp.br","unifesp","BCTeste"));
        return map;
    }



}
