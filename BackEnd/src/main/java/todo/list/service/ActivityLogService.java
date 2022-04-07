package todo.list.service;

import org.springframework.stereotype.Service;
import todo.list.domain.ActivityLog;
import todo.list.repository.ActivityLogRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ActivityLogService {

    private final ActivityLogRepository activityLogRepository;

    public ActivityLogService(ActivityLogRepository activityLogRepository) {
        this.activityLogRepository = activityLogRepository;
    }

    public List<ActivityLogDto> findActivityLogs() {
        List<ActivityLog> activityLogs = activityLogRepository.findAll();
        return IntStream.range(0, activityLogs.size())
                .mapToObj(i -> new ActivityLogDto(i, activityLogs.get(i)))
                .collect(Collectors.toList());
    }
}
