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
@TableName("order")
public class Order {

    /**
     * uid
     */
    @TableId(value = "n_uid", type = IdType.AUTO)
    private long uid;
    /**
     * 商品id
     */
    @TableField("n_goods_id")
    private int goodsId;

    /**
     * 状态
     */
    @TableField("n_state")
    private int state;

    /**
     * 实际价格
     */
    @TableField("n_price")
    private double price;
    /**
     * 创建时间
     */
    @TableField("d_create")
    private Date createTime;

    @TableField("d_last")
    private Date last;
}
