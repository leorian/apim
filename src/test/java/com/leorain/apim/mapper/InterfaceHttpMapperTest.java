package com.leorain.apim.mapper;

import com.itextpdf.text.DocumentException;
import com.leorain.apim.entity.InterfaceHttpEntity;
import com.leorain.apim.entity.ProjectEntity;
import com.leorain.apim.enums.InterfaceTypeEnum;
import com.leorain.apim.sevice.InterfaceHttpService;
import com.leorain.apim.sevice.InterfaceParamService;
import com.leorain.apim.sevice.InterfaceResultService;
import com.leorain.apim.sevice.ProjectService;
import com.leorain.apim.tools.HttpITextExportPdfUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InterfaceHttpMapperTest {

    public static final String DEST = "results/tables/httpInterface.pdf";

    @Autowired
    private InterfaceHttpMapper interfaceHttpMapper;

    @Autowired
    private InterfaceHttpService interfaceHttpService;

    @Autowired
    private InterfaceParamService interfaceParamService;

    @Autowired
    private InterfaceResultService interfaceResultService;

    @Autowired
    private ProjectService projectService;

    @Test
    public void testInsert() throws Exception {
        interfaceHttpMapper.insert(new InterfaceHttpEntity(1l, 1l, "用户接口",
                "1", "com", "1", "5", "dd"));
        interfaceHttpMapper.insert(new InterfaceHttpEntity(2l, 1l, "用户接口",
                "1", "com", "1", "5", "dd"));
        interfaceHttpMapper.insert(new InterfaceHttpEntity(3l, 1l, "用户接口",
                "1", "com", "1", "5", "dd"));

        Assert.assertEquals(3, interfaceHttpMapper.getAll().size());
    }

    @Test
    public void testQuery() throws Exception {
        List<InterfaceHttpEntity> interfaceHttpEntities = interfaceHttpMapper.getAll();
        if (interfaceHttpEntities == null || interfaceHttpEntities.size() == 0) {
            System.out.println("is null");
        } else {
            System.out.println(interfaceHttpEntities.toString());
        }
    }

    @Test
    public void testUpdate() throws Exception {
        InterfaceHttpEntity interfaceHttpEntity = interfaceHttpMapper.getOne(1l);
        System.out.println(interfaceHttpEntity.toString());
        interfaceHttpEntity.setDescription("com.bozhong.hello.service.UserService");
        interfaceHttpMapper.update(interfaceHttpEntity);
        Assert.assertTrue(("com.bozhong.hello.service.UserService".equals(interfaceHttpMapper.getOne(1l).getDescription())));
    }

    @Test
    public void testExportPdf() throws IOException, DocumentException {
        Long projectId = 20170707105701696l;
        ProjectEntity projectEntity = projectService.findProjectEntity(projectId);
        List<InterfaceHttpEntity> interfaceHttpEntities = interfaceHttpService.findInterfaceHttpEntities(projectId);
        if (!CollectionUtils.isEmpty(interfaceHttpEntities)) {
            for (InterfaceHttpEntity interfaceHttpEntity : interfaceHttpEntities) {
                interfaceHttpEntity.setInterfaceParamEntities(interfaceParamService.
                        findInterfaceParamEntityByInterfaceId(interfaceHttpEntity.getId(), InterfaceTypeEnum.HTTP));
                interfaceHttpEntity.setInterfaceResultEntities(interfaceResultService.
                        findInterfaceResultEntitiesByInterfaceId(interfaceHttpEntity.getId(),
                                InterfaceTypeEnum.HTTP));
            }
        }
        HttpITextExportPdfUtil.exportPdf(projectEntity, interfaceHttpEntities, DEST);
    }
}