package pl.paprocka.apisurveysquizzes.config;

public enum  Roles {
    ADMIN("ADMIN", "ROLE_ADMIN"),
    USER("USER", "ROLE_USER");
    //MANAGER("MANAGER", "ROLE_MANAGER");  pamietac o przecinku

    private String roleName;
    private String authorityName;

    Roles(String roleName, String authorityName) {
        this.roleName = roleName;
        this.authorityName = authorityName;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getAuthorityName() {
        return authorityName;
    }
}
