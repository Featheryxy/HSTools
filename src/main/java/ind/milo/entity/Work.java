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
    private String mdfDesc;
    private String version;
    private String requireNo;
    private Date deadline;
    private String tagId;
    private String filePath;
}
