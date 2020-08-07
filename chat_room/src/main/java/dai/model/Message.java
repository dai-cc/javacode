package dai.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class Message {
    private int messageId;
    private int userId;
    private int channelId;
    private String content;
    private Timestamp sendTime;

    // 此处再新增一个字段. 此处这里的 nickName 就和 userId 是对应的.
    // 直接把用户的昵称放到这里, 方便后面的界面显示.
    // nickName 在 message 表中并不存在. 可以根据 userId 在 user 表中查到
    private String nickName;
}