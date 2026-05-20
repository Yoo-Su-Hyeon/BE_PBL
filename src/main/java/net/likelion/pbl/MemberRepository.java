package net.likelion.pbl;

import net.likelion.pbl.role.Role;
import java.util.List;


public interface MemberRepository {
    void save(Role member);
    Role findByName(String name);
    List<Role> findAll();
    void updateByName(String name, Role member);
    boolean existsByName(String name);
    boolean deleteByName(String name);
}