
package com.sawforgarden.myapp.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.mail.internet.MimeMessage;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sawforgarden.myapp.CloudCommunicationPlatform.SendSms;
import com.sawforgarden.myapp.POJO.HashMaps;
import com.sawforgarden.myapp.POJO.POJO;
import com.sawforgarden.myapp.POJO.SendMail;
//import com.journaldev.spring.form.model.Employee;
import com.sawforgarden.myapp.POJO.VariableValidator;
import com.fasterxml.jackson.annotation.JsonView;
import com.sawforgarden.myapp.dao.AdminDAO;
import com.sawforgarden.myapp.dao.CommentDAO;
import com.sawforgarden.myapp.dao.OrderDAO;
import com.sawforgarden.myapp.dao.ProductDAO;
import com.sawforgarden.myapp.dao.UserDAO;
import com.sawforgarden.myapp.entity.Product;
import com.sawforgarden.myapp.jdbc.ExistingQueryParmeters;
import com.sawforgarden.myapp.jdbc.GetQuery;
import com.sawforgarden.myapp.jdbc.InsertToDatabase;
import com.sawforgarden.myapp.model.AdminInfo;
import com.sawforgarden.myapp.model.AjaxResponseBody;
import com.sawforgarden.myapp.model.CartInfo;
import com.sawforgarden.myapp.model.CommentInfo;
import com.sawforgarden.myapp.model.CustomerInfo;

import com.sawforgarden.myapp.model.OrderDetailInfo;
import com.sawforgarden.myapp.model.OrderInfo;
import com.sawforgarden.myapp.model.PaginationResult;
import com.sawforgarden.myapp.model.ProductInfo;
import com.sawforgarden.myapp.model.ReceiveCodeInfo;
import com.sawforgarden.myapp.model.RecentlyViewedItems;
import com.sawforgarden.myapp.model.RegisterInfo;
import com.sawforgarden.myapp.model.RestorePassword;
import com.sawforgarden.myapp.model.SortType;
import com.sawforgarden.myapp.model.SortingVariables;
import com.sawforgarden.myapp.model.Views;
import com.sawforgarden.myapp.util.Utils;
import com.sawforgarden.myapp.validator.AdminToggleValidation;
import com.sawforgarden.myapp.validator.CartValidator;
import com.sawforgarden.myapp.validator.CommentInfoValidator;
import com.sawforgarden.myapp.validator.EditCommentInfoValidator;
import com.sawforgarden.myapp.validator.ProductInfoValidator;
import com.sawforgarden.myapp.validator.RegisterInfoValidator;
import com.sawforgarden.myapp.validator.RestorePasswordInfoValidator;
import com.sawforgarden.myapp.model.EditComment;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.apache.log4j.Logger;
//import org.apache.log4j.LoggerFactory;

@Controller
@SessionAttributes({"RegisterData", "NameLoggedUser", "EmailLoggedUser", "CommentStar"
	,"TemporaryVariable","CustomerForm","recentlyvieweditems","TopMenuInstruments","cartForm","TagsSorting",
	"CartForItemsOfTopMenu","searchName","sortBy","categorySort","brandSort","priceSorting","ratingSorting"
	,"TopMenuBrands","TopMenuInstruments"
})

public class HomeController {
		
}
