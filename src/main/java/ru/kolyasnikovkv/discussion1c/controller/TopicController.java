package ru.kolyasnikovkv.discussion1c.controller;

import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kolyasnikovkv.discussion1c.dto.CommentsByTopic;
import ru.kolyasnikovkv.discussion1c.dto.UserDto;
import ru.kolyasnikovkv.discussion1c.model.Topic;
import ru.kolyasnikovkv.discussion1c.model.User;
import ru.kolyasnikovkv.discussion1c.service.CommentService;
import ru.kolyasnikovkv.discussion1c.service.TopicService;
import ru.kolyasnikovkv.discussion1c.service.UserService;
import ru.kolyasnikovkv.discussion1c.util.Result;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = TopicController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class TopicController extends BaseController {

    @Autowired
    private TopicService topicService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private final UserService userService;

    static final String REST_URL = "/rest/topic";

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        // Запросить детали темы
        Topic topic = topicService.selectById(id);
        // Запрос комментариев к теме
        List<CommentsByTopic> comments = commentService.selectByTopicId(id);
        // Запрос информации об авторе темы
        User topicUser = userService.selectById(topic.getUserId());
        // Запрос, сколько избранных в теме
        //List<Collect> collects = collectService.selectByTopicId(id);
        // Если вы вошли в систему, проверьте, одобрили ли вы эту тему
//        User user = getApiUser(false);
//        if (user != null) {
//            Collect collect = collectService.selectByTopicIdAndUserId(id, user.getId());
//            map.put("collect", collect);
//        }
//        // 话题浏览量+1
//        String ip = IpUtil.getIpAddr(request);
//        ip = ip.replace(":", "_").replace(".", "_");
//        topic = topicService.updateViewCount(topic, ip);
//        topic.setContent(SensitiveWordUtil.replaceSensitiveWord(topic.getContent(), "*", SensitiveWordUtil.MinMatchType));

        map.put("topic", topic);
//        map.put("tags", tags);
        map.put("comments", comments);
        map.put("topicUser", topicUser);
//        map.put("collects", collects);
        return success(map);
    }

   @PostConstruct()
   public void PostConstractHandler(){
       Logger logger = Logger.getLogger(TopicController.class);
       logger.info("CountryController - PostConstruct");
   }

   @PreDestroy
   public void PreDestroy(){
       Logger logger = Logger.getLogger(TopicController.class);
       logger.info("CountryController - PreDestroy");
   }
    //http://localhost:8080/rest/user/1
//   @GetMapping("/{id}")
//   @ResponseBody
//    public ResponseEntity<UserDto> get(@PathVariable Integer id) {
//       UserDto userDto = userService.get(id);
//       return ok(userDto);
//       /*ObjectMapper objectMapper = new ObjectMapper();
//       String json = objectMapper.writeValueAsString(result);
//       return json;*/
//    }
//
//    @PostMapping(value ="/add", consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public ResponseEntity<UserDto> add(@RequestBody UserDto request) {
//        //if (!accountRepository.existsByNameAndOwnerId(request.getName(), userDetails.getId())) {
//        UserDto countryDto = userService.create(request);
//        return ok(countryDto);
//    }
//
//    @PostMapping(value ="/addStr", consumes = MediaType.TEXT_PLAIN_VALUE)
//    @ResponseBody
//    public ResponseEntity<UserDto> addStr(@RequestBody String request) {
//        //if (!accountRepository.existsByNameAndOwnerId(request.getName(), userDetails.getId())) {
//        UserDto userDto = JsonUtil.readValue(request, UserDto.class);
//        userDto = userService.create(userDto);
//        return ok(userDto);
//    }
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
