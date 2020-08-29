package com.example.demo.model.dto;

import com.example.demo.model.PageQueryRequest;
import com.example.demo.model.enmu.ManageOrderClauseEnum;
import com.example.demo.model.enmu.OrderDirectionEnum;
import lombok.Data;

/**
 * @author zhuluxu
 * 部门详细数据
 */
@Data
public class DeptAssetDetailReqDTO extends PageQueryRequest {
    /**
     * 部门健康分拆解查询
     */
    private String departmentCode1;

    private String departmentCode2;

    private String departmentCode3;

    private String projectCode;

    private Long projectId;

    private String owner;

    private String orderClause = ManageOrderClauseEnum.assetImpactFactor.name();

    private String orderDirection = OrderDirectionEnum.DESC.getDirection();
}
