package net.likelion.pbl;

import net.likelion.pbl.dto.LionCreateRequest;
import net.likelion.pbl.dto.LionUpdateRequest;
import net.likelion.pbl.dto.StaffCreateRequest;
import net.likelion.pbl.dto.StaffUpdateRequest;
import net.likelion.pbl.role.Lion;
import net.likelion.pbl.role.Role;
import net.likelion.pbl.role.Staff;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public Lion createLion(LionCreateRequest request) {
        if (repository.existsByName(request.getName())) {
            return null;
        }

        Lion lion = new Lion(
                request.getName(),
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                request.getStudentId()
        );

        repository.save(lion);
        return lion;
    }

    public Staff createStaff(StaffCreateRequest request) {
        if (repository.existsByName(request.getName())) {
            return null;
        }

        Staff staff = new Staff(
                request.getName(),
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                request.getPosition()
        );

        repository.save(staff);
        return staff;
    }

    public Lion updateLion(String name, LionUpdateRequest request) {
        Role member = repository.findByName(name);

        if (member == null) {
            return null;
        }

        if (!(member instanceof Lion)) {
            return null;
        }

        Lion lion = (Lion) member;

        lion.setMajor(request.getMajor());
        lion.setGeneration(request.getGeneration());
        lion.setPart(request.getPart());
        lion.setStudentId(request.getStudentId());

        return lion;
    }

    public Staff updateStaff(String name, StaffUpdateRequest request) {
        Role member = repository.findByName(name);

        if (member == null) {
            return null;
        }

        if (!(member instanceof Staff)) {
            return null;
        }

        Staff staff = (Staff) member;

        staff.setMajor(request.getMajor());
        staff.setGeneration(request.getGeneration());
        staff.setPart(request.getPart());
        staff.setPosition(request.getPosition());

        return staff;
    }

    public boolean deleteMember(String name) {
        return repository.deleteByName(name);
    }

    public boolean register(Role member) {
        if (repository.existsByName(member.getName())) {
            return false;
        }
        repository.save(member);
        return true;
    }

    public Role searchByName(String name) {
        return repository.findByName(name);
    }

    public List<Role> getAllMembers() {
        return repository.findAll();
    }

    public boolean isEmpty() {
        return repository.findAll().isEmpty();
    }
}