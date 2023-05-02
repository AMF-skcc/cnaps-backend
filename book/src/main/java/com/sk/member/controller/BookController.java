package com.sk.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BookController {
//
//    // TODO 생성자 주입으로 전체 변경
//    @Autowired
//    private MemberService memberService;
//
//    // TODO 리턴되는 자원을 모두 DTO로 바꿀 것
//    // TODO 각종 NULL Check 해야하는 것들 및 방어코드
//    @PostMapping("/members")
//    public ResponseEntity<Member> createMember(@RequestBody MemberDto memberDto) {
//        // Extract UserDto fields and pass them to UserService for User creation
//        String username = memberDto.getUsername();
//        String nickname = memberDto.getNickname();
//        String email = memberDto.getEmail();
//        String role = "-"; // 생성시 default Role
//        String password = memberDto.getPassword();
//
//        Member createdMember = memberService.createMember(username, nickname, email, role, password);
//
//        // Return the created User entity as the response with HTTP status 201 (Created)
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdMember);
//    }
//
//    @GetMapping("/members")
//    public ResponseEntity<Page<Member>> getAllUsers(@PageableDefault(value = 10) Pageable pageable) { // 입력이 없으면 10개씩 조회
//        Page<Member> allUsers = memberService.getAllUsers(pageable);
//        return ResponseEntity.status(HttpStatus.OK).body(allUsers);
//    }
//
//    @GetMapping("/members/{email}")
//    public ResponseEntity<Member> getMemberByEmail(@PathVariable String email) {
//        Member member = memberService.findByEmail(email);
//        if (member == null) {
//            throw new ApiException(ApiStatus.NO_SUCH_MEMBER);
//        }
//        return ResponseEntity.status(HttpStatus.OK).body(member);
//    }
//
//    @PutMapping("/members/{email}")
//    public ResponseEntity<Member> updateMember(@RequestHeader(name = "CNAPS_ROLE", required = false) String role,
//                                               @RequestHeader(name = "USER_EMAIL", required = false) String headerEmail,
//                                               @PathVariable String email,
//                                               @RequestBody MemberDto memberDto) {
//        // TODO 권한 확인 추가, 비번 변경과 일반 정보 변경을 동일하게 할 것인지 결정 필요. ROLE은 별도로 변경
//
//        Member member = memberService.updateMember(memberDto.getEmail(), memberDto.getNickname(), memberDto.getPassword());
//        return ResponseEntity.status(HttpStatus.OK).body(member);
//    }
//
//    @DeleteMapping("/members/{email}")
//    public ResponseEntity<Boolean> updateMember(@RequestHeader(name = "CNAPS_ROLE", required = false) String role,
//                                               @RequestHeader(name = "USER_EMAIL", required = false) String headerEmail,
//                                               @PathVariable String email) {
//        // TODO 권한 확인 추가
//        boolean success = memberService.deleteMember(email);
//        return ResponseEntity.status(HttpStatus.OK).body(success);
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<Boolean> login(@RequestBody MemberDto memberDto) {
//        String email = memberDto.getEmail();
//        String password = memberDto.getPassword();
//
//        // email 주소로 사용자 조회
//        Member member = memberService.findByEmail(email);
//
//        // 로그인 처리 - 로그인 실패 시, 401 오류로 처리할 수도 있음.
//        boolean success = member.login(email, password);
//        if (!success) {
//            throw new ApiException(ApiStatus.LOGIN_FAILED);
//        }
//
//        return ResponseEntity.status(HttpStatus.OK).header("CNAPS_ROLE", member.getRole()).body(true);
//    }
}
