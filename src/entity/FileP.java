package entity;

public class FileP {
    private int id;
    private String file_name;
    private String file_desc;
    private String file_auto_name;
    private String user_name;

    public FileP() {
    }

    public FileP(String file_name, String file_desc, String file_auto_name, String user_name) {
        this.file_name = file_name;
        this.file_desc = file_desc;
        this.file_auto_name = file_auto_name;
        this.user_name = user_name;
    }

    public FileP(int id, String file_name, String file_desc, String file_auto_name, String user_name) {
        this.id = id;
        this.file_name = file_name;
        this.file_desc = file_desc;
        this.file_auto_name = file_auto_name;
        this.user_name = user_name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public void setFile_desc(String file_desc) {
        this.file_desc = file_desc;
    }

    public void setFile_auto_name(String file_auto_name) {
        this.file_auto_name = file_auto_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getId() {
        return id;
    }

    public String getFile_name() {
        return file_name;
    }

    public String getFile_desc() {
        return file_desc;
    }

    public String getFile_auto_name() {
        return file_auto_name;
    }

    public String getUser_name() {
        return user_name;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", file_name='" + file_name + '\'' +
                ", file_desc='" + file_desc + '\'' +
                ", file_auto_name='" + file_auto_name + '\'' +
                ", user_name='" + user_name + '\'' +
                '}';
    }
}
