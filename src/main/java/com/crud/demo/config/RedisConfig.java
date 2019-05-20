package com.crud.demo.config;

import com.crud.demo.model.Person;
import com.crud.demo.repo.PersonRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


@Configuration
public class RedisConfig {

	@Bean
	public PersonRepository repository(RedisTemplate<String, Person> redisTemplate) {
		return new PersonRepository(redisTemplate);
	}

	@Bean
	public RedisTemplate<String, Person> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, Person> template = new RedisTemplate();

		template.setConnectionFactory(redisConnectionFactory);

//		RedisSerializer<String> stringSerializer = new StringRedisSerializer();
		RedisSerializer<Person> personSerializer = new Jackson2JsonRedisSerializer<>(Person.class);

//		template.setKeySerializer(stringSerializer);
//		template.setValueSerializer(personSerializer);
//		template.setHashKeySerializer(stringSerializer);
		template.setHashValueSerializer(personSerializer);

		return template;
	}
}