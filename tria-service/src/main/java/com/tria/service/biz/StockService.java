package com.tria.service.biz;

import com.tria.dto.req.IdReq;
import com.tria.dto.req.StockAddReq;
import com.tria.dto.req.StockUpdateReq;

public interface StockService {

    /**
     * 新增库存记录
     *
     * @param stockAddReq 库存信息传输对象（包含商品ID、仓库ID、数量、批次号等）
     */
    void addStock(StockAddReq stockAddReq);

    /**
     * 修改现有库存记录
     *
     * @param stockDTO 库存修改信息传输对象（必须包含库存ID）
     * @return true表示修改成功，false表示未找到对应记录
     * @throws IllegalArgumentException 当修改后的数量为负数或库存ID无效时抛出
     */
    boolean updateStock(StockUpdateReq stockDTO);

    /**
     * 根据库存ID删除库存记录（逻辑删除）
     *
     * @param idReq 库存记录ID
     * @return true表示删除成功，false表示记录不存在或已删除
     * @throws IllegalArgumentException 当stockId为null或≤0时抛出
     */
    boolean deleteStock(IdReq idReq);

    /**
     * 查询库存列表
     */
    void queryStock(IdReq idReq);

    // /**
    //  * 批量导入库存数据（Excel/CSV格式）
    //  *
    //  * @param file 待导入的文件（支持.xlsx、.xls、.csv格式）
    //  * @param operatorId 操作人ID（用于记录操作日志）
    //  * @return 导入结果汇总（成功条数、失败条数、失败详情列表）
    //  * @throws IOException 当文件读取异常时抛出
    //  * @throws DataValidationException 当数据格式校验不通过时抛出（包含错误行号）
    //  */
    // ImportResult batchImportStock(MultipartFile file, Long operatorId);
}