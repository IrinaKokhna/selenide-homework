package guru.qa.domain;

public enum MenuItem {
    LIBRARY("Библиотека"), HISTORY("История");
    private String desc;
    MenuItem (String desc) {
        this.desc = desc;
    }
    public String getDesc() {
        return desc;
    }
}
