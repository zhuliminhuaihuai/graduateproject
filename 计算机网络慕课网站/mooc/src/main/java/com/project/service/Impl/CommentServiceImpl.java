package com.project.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.common.Const;
import com.project.common.LayUiPageResponse;
import com.project.common.ServerResponse;
import com.project.dao.CommentMapper;
import com.project.dao.TimeTableMapper;
import com.project.pojo.Comment;
import com.project.pojo.TimeTable;
import com.project.pojo.User;
import com.project.service.ICommentService;
import com.project.util.PublicUtil;
import com.project.vo.CommentQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * CommentServiceImpl
 *
 * @author {zhulimin}
 * @date 2020/2/6 0006 上午 1:43
 */
@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private TimeTableMapper timeTableMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public ServerResponse addComment(HttpServletRequest request, Integer timetableId, String educationCommentText) {

        User user = (User) request.getSession().getAttribute(Const.ManagerToken.SESSION);
        if (user.getUserRole() != Const.Role.ROLE_STUDENT) {
            return ServerResponse.createByErrorMessage("很抱歉!只能学生进行留言");
        }
        TimeTable timeTable = timeTableMapper.selectByPrimaryKey(timetableId);
        Comment comment = new Comment();
        comment.setEducationCommentCreateTime(new Date());
        comment.setEducationCommentCode(PublicUtil.setCode("C"));
        comment.setCoursesCode(timeTable.getCoursesCode());
        comment.setCoursesTitle(timeTable.getCoursesTitle());
        comment.setStudenrCode(timeTable.getStudentCode());
        comment.setStudentName(timeTable.getStudentName());
        comment.setTercherCode(timeTable.getTercherCode());
        comment.setTercherName(timeTable.getTercherName());
        comment.setEducationCommentText(educationCommentText);
        int count = commentMapper.insertSelective(comment);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("留言成功,已通知到对应老师，等待消息");
        } else {
            return ServerResponse.createByErrorMessage("留言失败");
        }
    }

    @Override
    public LayUiPageResponse getCommentList(CommentQueryVo commentQueryVo, Integer page, Integer limit, Integer userRole, String userCode) {

        if (userRole == Const.Role.ROLE_STUDENT) {
            commentQueryVo.setStudenrCode(userCode);
        } else if (userRole == Const.Role.ROLE_TEACHER) {
            commentQueryVo.setTercherCode(userCode);
        }
        PageHelper.startPage(page, limit);
        List<Comment> commentList = commentMapper.getCommentList(commentQueryVo);
        if (commentList.size() > 0) {
            PageInfo pageInfo = new PageInfo(commentList);
            return LayUiPageResponse.createBySuccess(commentList, pageInfo.getTotal(), page, limit);
        } else {
            return LayUiPageResponse.createByErrorMessage("暂无留言!");
        }

    }

    @Override
    public ServerResponse deleteComment(Integer educationCommentId) {

        int count = commentMapper.deleteByPrimaryKey(educationCommentId);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("删除成功!");
        } else {
            return ServerResponse.createByErrorMessage("删除失败!");
        }
    }
}
