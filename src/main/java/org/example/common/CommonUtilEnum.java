package org.example.common;

public enum CommonUtilEnum {
    SKILL_SET(new String[]{"Java", "DevOps", "Angular", "Kubernetes", "DotNet", "C", "C++", "Groovy", "Python", "Unix"}),
    USER_NAME(new String[]{"Pradeep", "Deepak", "Leena", "Roopa", "Poorvik", "Yashika", "Roopasri", "Anu", "Kamala", "Vimala"});

    private String[] skill;

    CommonUtilEnum(String[] skill) {
        this.skill = skill;
    }

    public String[] skill() {
        return this.skill;
    }

    public int length() {
        return this.skill.length;
    }
}
