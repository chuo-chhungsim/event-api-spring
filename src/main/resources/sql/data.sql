-- Insert venues
INSERT INTO tbl_venue (venue_id, venue_name, location) VALUES
                                                           ('11111111-1111-1111-1111-111111111111', 'ព្រះរាជដំណាក់', 'ភ្នំពេញ'),
                                                           ('22222222-2222-2222-2222-222222222222', 'សាលមន្ទីរតនារាជ', 'សៀមរាប'),
                                                           ('33333333-3333-3333-3333-333333333333', 'អាគារសម្តេចឪ', 'កណ្តាល'),
                                                           ('44444444-4444-4444-4444-444444444444', 'សាលពិព័រណ៍អន្តរជាតិ', 'ភ្នំពេញ'),
                                                           ('55555555-5555-5555-5555-555555555555', 'សាលស្រុកខ្មែរ', 'បាត់ដំបង');

-- Insert attendees
INSERT INTO tbl_attendee (attendee_id, attendee_name, email) VALUES
                                                                 ('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa', 'សុខ សំអាង', 'soksamang@example.com'),
                                                                 ('bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb', 'ម៉ៅ សុធារី', 'maosotheary@example.com'),
                                                                 ('cccccccc-cccc-cccc-cccc-cccccccccccc', 'ហេង សំណាង', 'hengsamnang@example.com'),
                                                                 ('dddddddd-dddd-dddd-dddd-dddddddddddd', 'ធី បញ្ញា', 'thipanha@example.com'),
                                                                 ('eeeeeeee-eeee-eeee-eeee-eeeeeeeeeeee', 'វង្ស សុផល', 'vongsophal@example.com'),
                                                                 ('ffffffff-ffff-ffff-ffff-ffffffffffff', 'នារី សុភាព', 'nearisopheap@example.com'),
                                                                 ('11111111-aaaa-1111-aaaa-111111111111', 'រិទ្ធិ វិចិត្រ', 'rithyvicheth@example.com'),
                                                                 ('22222222-bbbb-2222-bbbb-222222222222', 'សុខុម ម៉ាលី', 'sokhormaly@example.com');

-- Insert events
INSERT INTO tbl_event (event_id, event_name, event_date, venue_id) VALUES
                                                                       ('aaaaaaaa-1111-aaaa-1111-aaaaaaaa1111', 'ពិព័រណ៍សិល្បៈខ្មែរ', '2023-11-15', '11111111-1111-1111-1111-111111111111'),
                                                                       ('bbbbbbbb-2222-bbbb-2222-bbbbbbbb2222', 'ការប្រគំតន្ត្រីបុរាណ', '2023-12-05', '22222222-2222-2222-2222-222222222222'),
                                                                       ('cccccccc-3333-cccc-3333-cccccccc3333', 'សិល្បៈរបាំអប្សរា', '2024-01-20', '33333333-3333-3333-3333-333333333333'),
                                                                       ('dddddddd-4444-dddd-4444-dddddddd4444', 'ពិព័រណ៍អាហារខ្មែរ', '2024-02-10', '44444444-4444-4444-4444-444444444444'),
                                                                       ('eeeeeeee-5555-eeee-5555-eeeeeeee5555', 'ព្រេងរឿងព្រេងខ្មែរ', '2024-03-08', '55555555-5555-5555-5555-555555555555');

-- Insert join table entries
INSERT INTO tbl_event_attendee (event_id, attendee_id) VALUES
                                                           ('aaaaaaaa-1111-aaaa-1111-aaaaaaaa1111', 'aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa'),
                                                           ('aaaaaaaa-1111-aaaa-1111-aaaaaaaa1111', 'cccccccc-cccc-cccc-cccc-cccccccccccc'),
                                                           ('aaaaaaaa-1111-aaaa-1111-aaaaaaaa1111', 'eeeeeeee-eeee-eeee-eeee-eeeeeeeeeeee'),
                                                           ('aaaaaaaa-1111-aaaa-1111-aaaaaaaa1111', '11111111-aaaa-1111-aaaa-111111111111'),
                                                           ('bbbbbbbb-2222-bbbb-2222-bbbbbbbb2222', 'bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb'),
                                                           ('bbbbbbbb-2222-bbbb-2222-bbbbbbbb2222', 'dddddddd-dddd-dddd-dddd-dddddddddddd'),
                                                           ('bbbbbbbb-2222-bbbb-2222-bbbbbbbb2222', 'ffffffff-ffff-ffff-ffff-ffffffffffff'),
                                                           ('bbbbbbbb-2222-bbbb-2222-bbbbbbbb2222', '22222222-bbbb-2222-bbbb-222222222222'),
                                                           ('cccccccc-3333-cccc-3333-cccccccc3333', 'aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa'),
                                                           ('cccccccc-3333-cccc-3333-cccccccc3333', 'bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb'),
                                                           ('cccccccc-3333-cccc-3333-cccccccc3333', 'eeeeeeee-eeee-eeee-eeee-eeeeeeeeeeee'),
                                                           ('cccccccc-3333-cccc-3333-cccccccc3333', '11111111-aaaa-1111-aaaa-111111111111'),
                                                           ('dddddddd-4444-dddd-4444-dddddddd4444', 'cccccccc-cccc-cccc-cccc-cccccccccccc'),
                                                           ('dddddddd-4444-dddd-4444-dddddddd4444', 'dddddddd-dddd-dddd-dddd-dddddddddddd'),
                                                           ('dddddddd-4444-dddd-4444-dddddddd4444', 'ffffffff-ffff-ffff-ffff-ffffffffffff'),
                                                           ('dddddddd-4444-dddd-4444-dddddddd4444', '22222222-bbbb-2222-bbbb-222222222222'),
                                                           ('eeeeeeee-5555-eeee-5555-eeeeeeee5555', 'aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa'),
                                                           ('eeeeeeee-5555-eeee-5555-eeeeeeee5555', 'bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb'),
                                                           ('eeeeeeee-5555-eeee-5555-eeeeeeee5555', 'cccccccc-cccc-cccc-cccc-cccccccccccc'),
                                                           ('eeeeeeee-5555-eeee-5555-eeeeeeee5555', 'dddddddd-dddd-dddd-dddd-dddddddddddd');
