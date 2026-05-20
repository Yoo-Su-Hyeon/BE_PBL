package net.likelion.pbl.controller;

import net.likelion.pbl.MemberService;
import net.likelion.pbl.dto.*;
import net.likelion.pbl.role.Lion;
import net.likelion.pbl.role.Role;
import net.likelion.pbl.role.Staff;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/lions")
    public ResponseEntity<LionResponse> createLion(@RequestBody LionCreateRequest request) {
        Lion lion = memberService.createLion(request);

        if (lion == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(LionResponse.from(lion));
    }

    @PostMapping("/staffs")
    public ResponseEntity<StaffResponse> createStaff(@RequestBody StaffCreateRequest request) {
        Staff staff = memberService.createStaff(request);

        if (staff == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(StaffResponse.from(staff));
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getMember(@PathVariable String name) {
        Role member = memberService.searchByName(name);

        if (member == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        if (member instanceof Lion lion) {
            return ResponseEntity.ok(LionResponse.from(lion));
        }

        if (member instanceof Staff staff) {
            return ResponseEntity.ok(StaffResponse.from(staff));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/lions/{name}")
    public ResponseEntity<LionResponse> updateLion(
            @PathVariable String name,
            @RequestBody LionUpdateRequest request
    ) {
        Lion lion = memberService.updateLion(name, request);

        if (lion == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(LionResponse.from(lion));
    }

    @PutMapping("/staffs/{name}")
    public ResponseEntity<StaffResponse> updateStaff(
            @PathVariable String name,
            @RequestBody StaffUpdateRequest request
    ) {
        Staff staff = memberService.updateStaff(name, request);

        if (staff == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(StaffResponse.from(staff));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteMember(@PathVariable String name) {
        boolean deleted = memberService.deleteMember(name);

        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.noContent().build();
    }

}