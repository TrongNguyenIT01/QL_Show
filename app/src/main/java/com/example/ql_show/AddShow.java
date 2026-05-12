package com.example.ql_show;

public class AddShow {
    private String TenShow;
    private  String DiaDiem;
    private String ThoiGian;
    private String BauShow;
    private String GhiChu;

    public AddShow (String TenShow, String DiaDiem, String ThoiGian,
                    String BauShow, String GhiChu) {

        this.TenShow =TenShow;
        this.DiaDiem = DiaDiem;
        this.ThoiGian = ThoiGian;
        this.BauShow = BauShow;
        this.GhiChu = GhiChu;

    }
    public String getTenShow() {
        return TenShow;
    }

    public String getDiaDiem(){
        return DiaDiem;
    }

    public String getThoiGian() {
        return ThoiGian;
    }

    public String getBauShow() {
        return BauShow;
    }

    public String getGhiChu() {
        return GhiChu;
    }
}
