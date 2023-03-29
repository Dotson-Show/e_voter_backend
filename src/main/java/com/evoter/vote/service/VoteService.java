package com.evoter.vote.service;

import com.evoter.candidate.model.Candidate;
import com.evoter.candidate.service.CandidateService;
import com.evoter.user.model.User;
import com.evoter.user.service.UserService;
import com.evoter.vote.model.Vote;
import com.evoter.vote.repository.VoteRepository;
import com.evoter.vote.dto.AddVoteRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author showunmioludotun
 */

@Service
public class VoteService {
    private final VoteRepository voteRepository;
    private final UserService userService;
    private final CandidateService candidateService;

    public VoteService(VoteRepository voteRepository, UserService userService, CandidateService candidateService) {
        this.voteRepository = voteRepository;
        this.userService = userService;
        this.candidateService = candidateService;
    }

    public Vote addVote(AddVoteRequest request) throws Exception {
        User user = userService.getUserById(request.userId());
        candidateService.increamentVoteCount(request.candidateId());

        Vote vote = new Vote();
//        vote.setUserId(request.userId());
//        vote.setPollId(request.pollId());
//        return voteRepository.save(vote);
        return vote;
    }

    public List<Vote> getAllVotes() {
        return voteRepository.findAll();
    }

    public Vote getVoteById(Long id) {
        return voteRepository.findById(id).orElse(null);
    }

    // Encrypt AES Key with RSA Public Key
//    private static byte[] encryptAesKeyWithRsaPublicKey(PublicKey publicKey) throws Exception {
//        Cipher rsaCipher = Cipher.getInstance("RSA");
//        rsaCipher.init(Cipher.ENCRYPT_MODE, publicKey);
//        SecretKey aesKey = generateAESKey();
//        return rsaCipher.doFinal(aesKey.getEncoded());
//    }


//// Encrypt Election Data with AES Key
//    // Generate AES Key
//    private static SecretKey generateAESKey() throws Exception {
//        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
//        keyGen.init(256);
//        SecretKey key = keyGen.generateKey();
//        return key;
//    }

    // Helper method to convert a byte array to a hex string
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
