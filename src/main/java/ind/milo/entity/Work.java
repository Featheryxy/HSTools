package ind.milo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Work {
    private String mdfNo;
    private String mdfReason;
    private String mdfDetail;
    private String version;
    private String requireNo;
    private Date createDate;
}
