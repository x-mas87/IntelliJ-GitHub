package org.example;

public class User {
    public  String password;


    //패스워드초기화
    public void initPassword(PasswordGenerator passwordGenerator){
        //인터페이스를 만듬으로서 더 낮은 결합도를 유지하여 테스트를 실행할수있다
        //그래서 랜덤패스워드 제너레이터도 들어올수 있다
        // as-is
        //RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();

        // to-be
        String password = passwordGenerator.generatePassword();

        /*비밀번호가 최소8자이상 12자 이햐여야한다*/
        if (password.length() >=8 && password.length() <=12){
            this.password = password;
        }

    }

    public String getPassword() {
        return password;
    }
}
