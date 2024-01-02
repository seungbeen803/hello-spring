package hello.hellospring.domain;

public class Member {

    // 요구사항 : 회원ID, 이름

    // 시스템이 정해주는 ID
    private Long id;
    // 고객이 회원가입할 때 적는 이름
    private String name;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
