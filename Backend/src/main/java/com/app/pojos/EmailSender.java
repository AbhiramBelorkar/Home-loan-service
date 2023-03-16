package com.app.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmailSender 
{
  private String fromEmailId;
  
  private String toEmailId;
  
  private String subject;
  
  private String textBody;
}
