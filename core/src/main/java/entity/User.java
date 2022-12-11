package entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@TableName("user")
public class User {

    private int id;
    private int sex;
    private int age;
    private String name;
    private Date birth;

}
