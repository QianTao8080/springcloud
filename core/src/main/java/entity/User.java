package entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@TableName("user")
public class User {

    @TableId(value = "n_id", type = IdType.AUTO)
    private int id;
    @TableField("n_sex")
    private int sex;
    @TableField("n_age")
    private int age;
    @TableField("s_name")
    private String name;
    @TableField("d_birth")
    private Date birth;

}
