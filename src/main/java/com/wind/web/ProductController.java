package com.wind.web;

import com.wind.account.dao.IProductDao;
import com.wind.account.domain.ProductDO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/product/")
public class ProductController {

    @Resource
    private IProductDao productDao;

    @ResponseBody
    @RequestMapping("detail")
    public ProductDO detail(Long productId){
        return productDao.selectByPrimaryKey(productId);
    }


}
