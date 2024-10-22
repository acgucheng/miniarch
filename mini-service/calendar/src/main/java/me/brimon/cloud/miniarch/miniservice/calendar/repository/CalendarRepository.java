package me.brimon.cloud.miniarch.miniservice.calendar.repository;

import me.brimon.cloud.miniarch.miniservice.calendar.entity.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Integer>{

    @Override
    <S extends Calendar> List<S> saveAll(Iterable<S> entities);
}
