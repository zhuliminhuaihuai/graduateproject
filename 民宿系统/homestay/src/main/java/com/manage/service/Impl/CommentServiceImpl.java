package com.manage.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manage.common.Const;
import com.manage.common.LayUiPageResponse;
import com.manage.common.ServerResponse;
import com.manage.dao.CommentMapper;
import com.manage.dao.OrderMapper;
import com.manage.pojo.Comment;
import com.manage.pojo.Order;
import com.manage.pojo.User;
import com.manage.service.ICommentService;
import com.manage.util.PublicUtil;
import com.manage.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * CommentServiceImpl
 *
 * @author {zhulimin}
 * @date 2020/3/2 0002 下午 18:13
 */
@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public ServerResponse saveComment(Comment comment, Integer orderId) {

        Order order = orderMapper.selectByPrimaryKey(orderId);
        comment.setComCode(PublicUtil.setCode("C"));
        comment.setCommentCreateTime(new Date());
        comment.setCommentName(order.getCustomerName());
        comment.setCommentCode(order.getCustomerCode());
        comment.setTenantCode(order.getTenantCode());
        comment.setTenantName(order.getTenantName());
        comment.setRoomCode(order.getRoomCode());
        comment.setRoomSimpleRemark(order.getRoomSimpleRemark());
        int count = commentMapper.insertSelective(comment);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("评论成功");
        } else {
            return ServerResponse.createByErrorMessage("评论失败");
        }
    }

    @Override
    public LayUiPageResponse commentList(HttpServletRequest request, CommentVo commentVo, Integer page, Integer limit) {
        User user = (User) request.getSession().getAttribute(Const.ManagerToken.SESSION);
        if (user.getUserRole() == Const.Role.ROLE_CUSTOMER) {
            commentVo.setCommentCode(user.getUserCode());
        } else if (user.getUserRole() == Const.Role.ROLE_TENANT) {
            commentVo.setTenantCode(user.getUserCode());
        }
        PageHelper.startPage(page, limit);
        List<Comment> commentList = commentMapper.getCommentList(commentVo);
        if (commentList.size() > 0) {
            PageInfo pageInfo = new PageInfo(commentList);
            return LayUiPageResponse.createBySuccess(commentList, pageInfo.getTotal(), page, limit);
        }else{
            return LayUiPageResponse.createByErrorMessage("暂无数据！");
        }

    }

    @Override
    public ServerResponse deleteComment(Integer commentId) {
        int count = commentMapper.deleteByPrimaryKey(commentId);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("删除成功");
        } else {
            return ServerResponse.createByErrorMessage("删除失败");
        }
    }
}
