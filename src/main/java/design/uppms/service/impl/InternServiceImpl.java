package design.uppms.service.impl;

import design.uppms.model.po.InternPO;
import design.uppms.mapper.InternMapper;
import design.uppms.service.InternService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenli
 * @since 2021-02-08
 */
@Service
public class InternServiceImpl extends ServiceImpl<InternMapper, InternPO> implements InternService {

    @Autowired(required = false)
    private InternMapper internMapper;


    //填写每天实习情况
    @Override
    public boolean writeInformation(InternPO internPO, HttpServletRequest request) {
        //判断是不是实习生
        String uAttribute = request.getHeader("uAttribute");
        Integer code = Integer.valueOf(uAttribute);
        if (code==1){
            internMapper.insert(internPO);
            return true;
        }else {
            return false;
        }
    }


    //上传毕业设计资料
    @Override
    public String upload(MultipartFile file, HttpServletRequest request) throws ParseException, IOException {
        //判断是不是实习生
        String uAttribute = request.getHeader("uAttribute");
        Integer code = Integer.valueOf(uAttribute);
        if (code==1){
            String url = null;
            // 如果文件不为空，写入上传路径，进行文件上传
            if (!file.isEmpty()){
                //构建上传之后的地址
                String path = System.getProperty("user.dir") + "\\文件上传之后存放的文件夹名";


                //将当前时间转换成时间戳
                long longtime = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();

                //将时间戳和原名加一起，保证了名字的唯一性
                String fileName = longtime + file.getOriginalFilename();

                //判断路径是否存在，不存在则新创建一个
                File filepath = new File(path, fileName);
                if (!filepath.getParentFile().exists()) {
                    filepath.getParentFile().mkdirs();
                }
                //将文件上传到指定的位置
                file.transferTo(new File(path + File.separator + fileName));
                //拼写完整的路径
                url = path + "\\" + fileName;
                return url;
            }else {
                return "文件为空，不能上传";
            }
        }else {
            return "失败";
        }

    }








}
