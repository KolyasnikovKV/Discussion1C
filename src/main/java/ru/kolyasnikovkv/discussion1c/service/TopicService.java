package ru.kolyasnikovkv.discussion1c.service;

import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.kolyasnikovkv.discussion1c.dto.UserDto;
import ru.kolyasnikovkv.discussion1c.model.Topic;
import ru.kolyasnikovkv.discussion1c.model.User;
import ru.kolyasnikovkv.discussion1c.repository.jpa.CrudUserJpaDao;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class TopicService {

    private final CrudUserJpaDao repository;
    private final Converter<User, UserDto> converter;
    private final Converter<UserDto, User> converterDto;

   /* public List<AccountDTO> listByUser(Long userId) {
        return accountRepository.findAccountsByOwnerId(userId)
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList());
*/

/*    public Topic insert(String title, String content, String tags, User user, HttpSession session) {
        Topic topic = new Topic();
        topic.setTitle(Jsoup.clean(title, Whitelist.simpleText()));
        topic.setContent(content);
        topic.setInTime(new Date());
        topic.setUserId(user.getId());
        topic.setTop(false);
        topic.setGood(false);
        topic.setView(1);
        topic.setCollectCount(0);
        topic.setCommentCount(0);
        topicMapper.insert(topic);
        // 增加用户积分
        user.setScore(user.getScore() + Integer.parseInt(systemConfigService.selectAllConfig().get("create_topic_score")
                .toString()));
        userService.update(user);
        if (session != null) session.setAttribute("_user", user);
        if (!StringUtils.isEmpty(tags)) {
            // 保存标签
            List<Tag> tagList = tagService.insertTag(Jsoup.clean(tags, Whitelist.none()));
            // 处理标签与话题的关联
            topicTagService.insertTopicTag(topic.getId(), tagList);
        }
        // 索引话题
        indexedService.indexTopic(String.valueOf(topic.getId()), topic.getTitle(), topic.getContent());
        return topic;
    }
*/
    // 根据id查询话题
    @Override
    public Topic selectById(Integer id) {
        return topicMapper.selectById(id);
    }

    // 根据title查询话题，防止重复话题
    @Override
    public Topic selectByTitle(String title) {
        QueryWrapper<Topic> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Topic::getTitle, title);
        return topicMapper.selectOne(wrapper);
    }
    public UserDto get(Integer id) {
        User user = repository.findById(id);
       // checkNotFoundWithId(country, id);
        return converter.convert(user);
    }

    public void delete(Integer id) {
        //checkNotFoundWithId(repository.delete(id), id);

    }

    public UserDto create(UserDto userDto){
        User user = converterDto.convert(userDto);
        user = repository.save(user);
        return converter.convert(user);
    }

    public UserDto update(UserDto userDto) {
        User user = repository.findById(userDto.getId());
        //country = checkNotFoundWithId(country, countryDto.getId());
        user.setUsername(userDto.getName());
        user = repository.save(user);
        return converter.convert(user);
    }
}