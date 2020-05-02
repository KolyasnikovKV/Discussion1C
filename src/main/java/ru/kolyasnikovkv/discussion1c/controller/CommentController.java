package ru.kolyasnikovkv.discussion1c.controller;

import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import ru.kolyasnikovkv.discussion1c.dto.UserDto;
import ru.kolyasnikovkv.discussion1c.model.Comment;
import ru.kolyasnikovkv.discussion1c.model.Topic;
import ru.kolyasnikovkv.discussion1c.model.User;
import ru.kolyasnikovkv.discussion1c.service.CommentService;
import ru.kolyasnikovkv.discussion1c.service.TopicService;
import ru.kolyasnikovkv.discussion1c.service.UserService;
import ru.kolyasnikovkv.discussion1c.util.Result;
import ru.kolyasnikovkv.discussion1c.util.json.JsonUtil;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpSession;

import java.util.Date;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = CommentController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class CommentController extends BaseController {

   static final String REST_URL = "/rest/comment";
   private final UserService userService;


    @Autowired
    private CommentService commentService;
    @Autowired
    private TopicService topicService;

    // 创建评论
  /*  @PostMapping
    public Result create(@RequestBody Map<String, String> body, HttpSession session) {
        User user = getApiUser();
        ApiAssert.isTrue(user.getActive(), "Ваша учетная запись не была активирована, перейдите на страницу личных настроек, чтобы активировать свою учетную запись");
        String content = body.get("content");
        Integer topicId = StringUtils.isEmpty(body.get("topicId")) ? null : Integer.parseInt(body.get("topicId"));
        Integer commentId = StringUtils.isEmpty(body.get("commentId")) ? null : Integer.parseInt(body.get("commentId"));
        ApiAssert.notEmpty(content, "Пожалуйста, введите комментарий");
        ApiAssert.notNull(topicId, "А как насчет идентификатора темы?");
        Topic topic = topicService.selectById(topicId);
        ApiAssert.notNull(topic, "Вы опоздали на один шаг, возможно, тема была удалена");
        // Собрать объект комментария
        Comment comment = new Comment();
        comment.setCommentId(commentId);
        comment.setContent(content);
        comment.setInTime(new Date());
        comment.setTopicId(topic.getId());
        comment.setUserId(user.getId());
        comment = commentService.insert(comment, topic, user, session);
        // Фильтровать комментарии
        comment.setContent(SensitiveWordUtil.replaceSensitiveWord(comment.getContent(), "*", SensitiveWordUtil
                .MinMatchType));
        return success(comment);
    }
*/

    @PostConstruct()
   public void PostConstractHandler(){
       Logger logger = Logger.getLogger(CommentController.class);
       logger.info("CountryController - PostConstruct");
   }

   @PreDestroy
   public void PreDestroy(){
       Logger logger = Logger.getLogger(CommentController.class);
       logger.info("CountryController - PreDestroy");
   }
    //http://localhost:8080/rest/user/1
   @GetMapping("/{id}")
   @ResponseBody
    public ResponseEntity<UserDto> get(@PathVariable Integer id) {
       UserDto userDto = userService.get(id);
       return ok(userDto);
       /*ObjectMapper objectMapper = new ObjectMapper();
       String json = objectMapper.writeValueAsString(result);
       return json;*/
    }

    @PostMapping(value ="/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<UserDto> add(@RequestBody UserDto request) {
        //if (!accountRepository.existsByNameAndOwnerId(request.getName(), userDetails.getId())) {
        UserDto countryDto = userService.create(request);
        return ok(countryDto);
    }

    @PostMapping(value ="/addStr", consumes = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public ResponseEntity<UserDto> addStr(@RequestBody String request) {
        //if (!accountRepository.existsByNameAndOwnerId(request.getName(), userDetails.getId())) {
        UserDto userDto = JsonUtil.readValue(request, UserDto.class);
        userDto = userService.create(userDto);
        return ok(userDto);
    }
     ///return status(HttpStatus.BAD_REQUEST).build();
    //}

   /*private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final AccountToResponseConverter converter;

    @GetMapping("/accounts")
    @ResponseBody
    public ResponseEntity<List<AccountResponse>> listAll(@AuthenticationPrincipal CustomUserDetails userDetails) {
        List<Account> accounts = accountRepository.findAccountsByOwnerId(userDetails.getId());
        return ok(
                accounts.stream()
                        .map(converter::convert)
                        .collect(Collectors.toList())
        );
    }

    @PostMapping("/accounts")
    @ResponseBody
    public ResponseEntity<AccountResponse> add(@RequestBody AccountRequest request,
                                               @AuthenticationPrincipal CustomUserDetails userDetails) {
        if (!accountRepository.existsByNameAndOwnerId(request.getName(), userDetails.getId())) {
            Account account = new Account();
            account.setName(request.getName());
            account.setBalance(request.getBalance());
            account.setOwner(userRepository.getOne(userDetails.getId()));
            account = accountRepository.save(account);

            return ok(converter.convert(account));
        }
        return status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/accounts/{account:\\d+}")
    @ResponseBody
    public ResponseEntity<AccountResponse> update(@PathVariable Account account,
                                                  @RequestBody AccountRequest request,
                                                  @AuthenticationPrincipal CustomUserDetails userDetails) {
        if (account != null && account.getOwner().getId().equals(userDetails.getId())) {
            if (request.getName() != null) {
                account.setName(request.getName());
            }
            if (request.getBalance() != null) {
                account.setBalance(request.getBalance());
            }
            account = accountRepository.save(account);
            return ok(converter.convert(account));
        }
        return status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/accounts/{account:\\d+}")
    @ResponseBody
    public ResponseEntity<AccountResponse> delete(@PathVariable Account account,
                                                  @AuthenticationPrincipal CustomUserDetails userDetails) {
        if (account != null && userDetails.getId().equals(account.getOwner().getId())) {
            accountRepository.delete(account);
        }
        return status(HttpStatus.NO_CONTENT).build();
    }
    */
}
